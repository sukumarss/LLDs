package com.demo.dto.vehicle;

import com.demo.enums.ParkingSpotEnum;

public class Car extends Vehicle{
    public Car(){
        super(ParkingSpotEnum.COMPACT);
    }
}
