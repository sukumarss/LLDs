package com.demo.interfaces;

import com.demo.dto.ParkingEvent;

public interface Observer {
    void update(ParkingEvent event);
}
