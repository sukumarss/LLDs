package com.demo.dto.vehicle;

import com.demo.enums.ParkingSpotEnum;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vehicle {
    private static AtomicInteger x = new AtomicInteger(0);
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
    }

    private ParkingSpotEnum parkingSpotEnum;

    public Vehicle(ParkingSpotEnum pse){
        this.parkingSpotEnum=pse;
        id=x.incrementAndGet();
    }
}
