package org.academy.projects.controller.dto.mapping;

import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.model.Flight;
import org.academy.projects.service.planeManager.PlaneManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightRequest2Flight {

    private final PlaneManager planeManager;

    @Autowired
    public FlightRequest2Flight(PlaneManager planeManager){
        this.planeManager = planeManager;
    }

    public Flight map(FlightRequest flightRequest){

        Flight flight = new Flight();

        flight.setCityFrom(flightRequest.getCityFrom());

        flight.setCityTo(flightRequest.getCityTo());

        flight.setDepartureDate(flightRequest.getDepartureDate());

        flight.setArrivalDate(flightRequest.getArrivalDate());

        flight.setPrice(flightRequest.getPrice());

        flight.setPlane(planeManager.read(flightRequest.getPlane()));

        flight.setFreePlaces(planeManager.read(flightRequest.getPlane()).getNumberOfPlaces());

        return flight;

    }
}
