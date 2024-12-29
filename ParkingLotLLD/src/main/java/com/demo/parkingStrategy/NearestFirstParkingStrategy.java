package com.demo.parkingStrategy;

import com.demo.dto.ParkingLot;
import com.demo.dto.parkingSpot.ParkingSpot;
import com.demo.enums.ParkingSpotEnum;
import com.demo.exceptions.SpotNotFoundException;

import java.util.List;

public class NearestFirstParkingStrategy implements Strategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {

        List<ParkingSpot> parkingSpots= ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(parkingSpots.size()==0){
            throw new SpotNotFoundException("Spot not found in nearest firt strategy");
        }
        return parkingSpots.get(0);
    }


}
