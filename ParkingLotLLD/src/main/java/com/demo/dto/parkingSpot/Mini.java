package com.demo.dto.parkingSpot;

public class Mini extends ParkingSpot{
    public Mini(Integer floor){
        super(floor,20);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours*amount;
    }
}
