package com.demo.dto.vehicle;

import com.demo.enums.ParkingSpotEnum;

public class Truck extends Vehicle{
    public Truck(){
        super(ParkingSpotEnum.LARGE);
    }
}
