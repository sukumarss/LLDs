package com.demo.dto;

import com.demo.enums.ParkingSpotEnum;

import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {
    private static DisplayBoard displayBoard=null;
    private Map<ParkingSpotEnum,Integer> freeParkingSpots;

    public Map<ParkingSpotEnum, Integer> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<ParkingSpotEnum, Integer> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    private DisplayBoard(){
        this.freeParkingSpots=new HashMap<>();
    }

    public static DisplayBoard getInstance(){
        if(displayBoard==null){
            displayBoard=new DisplayBoard();
        }
        return displayBoard;
    }
}
