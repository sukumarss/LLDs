package com.demo.services;

import java.util.*;

import com.demo.dto.ParkingEvent;
import com.demo.dto.ParkingLot;
import com.demo.dto.ParkingTicket;
import com.demo.dto.parkingSpot.ParkingSpot;
import com.demo.dto.parkingSpot.spotDecorator.Wash;
import com.demo.dto.vehicle.Vehicle;
import com.demo.enums.ParkingEventType;
import com.demo.enums.ParkingSpotEnum;
import com.demo.exceptions.InvalidTicketException;
import com.demo.exceptions.SpotNotFoundException;
import com.demo.interfaces.DisplayService;
import com.demo.interfaces.Observer;
import com.demo.interfaces.ParkingService;
import com.demo.interfaces.ParkingSpotService;
import com.demo.parkingStrategy.Strategy;

public class ParkingServiceImpl implements ParkingService {
    Strategy parkingStrategy;
    ParkingLot parkingLot;
    DisplayService displayService;
    private List<Observer> observers;

    public ParkingServiceImpl(Strategy parkingStratetgy){
        this.parkingStrategy=parkingStratetgy;
        parkingLot=ParkingLot.getInstance();
        displayService= new DisplayServiceImpl();
        observers=new ArrayList<>();
    }
    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
        List<ParkingSpot> freeParkingSpots=parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpots=parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);
        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);
            if(parkingSpot.isFree()){
                synchronized (parkingSpot){
                    if(parkingSpot.isFree()){
                        parkingSpot.setFree(false);
                        freeParkingSpots.remove(parkingSpot);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket= new ParkingTicket(vehicle,parkingSpot);
                        ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.ENTRY,parkingSpotEnum);
                        notifyAllObservers(parkingEvent);
//                        displayService.update(parkingSpotEnum,-1);
                        return parkingTicket;
                    }
                    entry(vehicle);
                }
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public void addObserver(Observer observer){
        observers.add(observer);

    }

    public void notifyAllObservers(ParkingEvent parkingEvent){
        for(Observer observer : observers){
            observer.update(parkingEvent);
        }
    }

    private void addParkingSpotInFreeList(List<ParkingSpot> parkingSpots,ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
    }
    public void addWash(ParkingTicket parkingTicket){
        parkingTicket.setParkingSpot(new Wash(parkingTicket.getParkingSpot()));
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if(parkingTicket.getVehicle().equals(vehicle)){
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            int amount =   parkingSpot.getAmount();
            parkingSpot.setFree(true);
            parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
            addParkingSpotInFreeList(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()), parkingSpot);
            ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT,vehicle.getParkingSpotEnum());
            notifyAllObservers(parkingEvent);
            return amount;
        }
        else{
            throw new InvalidTicketException("This is invalid ticket");
        }
    }
}
