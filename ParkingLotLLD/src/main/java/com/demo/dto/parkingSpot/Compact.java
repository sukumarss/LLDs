package com.demo.dto.parkingSpot;

public class Compact extends ParkingSpot{
    public Compact(Integer floor){
        super(floor,30);
    }
    @Override
    public int cost(int parkingHours) {
        return parkingHours*amount;
    }
}
