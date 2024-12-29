package com.demo.services;

import com.demo.dto.ParkingEvent;
import com.demo.dto.ParkingLot;
import com.demo.dto.parkingSpot.ParkingSpot;
import com.demo.enums.ParkingEventType;
import com.demo.enums.ParkingSpotEnum;
import com.demo.interfaces.DisplayService;
import com.demo.interfaces.ParkingSpotService;

import java.lang.reflect.InvocationTargetException;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    DisplayService displayService=new DisplayServiceImpl();
    ParkingServiceImpl parkingService;

    @Override
    public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor) {

        try {
            ParkingSpot parkingSpot=(ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
//            ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT,vehicle.getParkingSpotEnum());
//            parkingService.notifyAllObservers(parkingEvent);
            displayService.update(parkingSpotEnum,1);
            return parkingSpot;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
