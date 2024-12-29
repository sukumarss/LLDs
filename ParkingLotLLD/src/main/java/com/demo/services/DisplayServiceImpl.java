package com.demo.services;

import com.demo.dto.DisplayBoard;
import com.demo.dto.ParkingEvent;
import com.demo.enums.ParkingEventType;
import com.demo.enums.ParkingSpotEnum;
import com.demo.interfaces.DisplayService;
import com.demo.interfaces.Observer;

public class DisplayServiceImpl implements DisplayService, Observer {


    @Override
    public void update(ParkingEvent event) {
        int current= DisplayBoard.getInstance().getFreeParkingSpots().get(event.getParkingSpotEnum());
        int change=0;
        if(event.getEventType().equals(ParkingEventType.ENTRY)){
            change=-1;
        }
        else{
            change=1;
        }
        int newCount = current+change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(event.getParkingSpotEnum(),newCount);
        return;
    }
    public void update(ParkingSpotEnum parkingSpotEnum,int change){
        Integer current= DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(current==null){
            current=0;
        }
        int newCount = current+change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum,newCount);

    }
}
