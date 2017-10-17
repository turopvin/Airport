package org.academy.projects.services;

import org.academy.projects.interfaces.flight.FlightManager;
import org.academy.projects.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    FlightManager flightManager;

    @Autowired
    public FlightService(FlightManager flightManager){
        this.flightManager = flightManager;
    }

    public Flight saveFlight(Flight flight){
        flightManager.create(flight);
        return flight;
    }


}
