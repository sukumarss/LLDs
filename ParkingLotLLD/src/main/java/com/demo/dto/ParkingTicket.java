package com.demo.dto;

import com.demo.dto.parkingSpot.ParkingSpot;
import com.demo.dto.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private static final AtomicInteger x = new AtomicInteger(0);
    private int id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime timeStamp;
     public ParkingTicket(Vehicle vehicle,ParkingSpot parkingSpot){
         this.parkingSpot=parkingSpot;
         this.vehicle=vehicle;
         timeStamp=LocalDateTime.now();
         id=x.incrementAndGet();
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public int getParkingHours(){
         return 2;
    }
}
