package com.demo.interfaces;

import com.demo.dto.ParkingTicket;
import com.demo.dto.vehicle.Vehicle;
import com.demo.exceptions.InvalidTicketException;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);

    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
