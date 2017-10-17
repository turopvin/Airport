package org.academy.projects.interfaces.flight;

import org.academy.projects.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightManager implements FlightManagement {

    FlightRepository flightRepository;

    @Autowired
    public FlightManager(final FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight create(Flight flight) {
        if (flight == null){
            throw new IllegalArgumentException("Flight can't be null");
        }
        return flightRepository.save(flight);
    }

    @Override
    public void delete(Flight flight) {
        if (flight == null){
            throw new IllegalArgumentException("Flight can't be null");
        }
        flightRepository.delete(flight);
    }

    @Override
    public List<Flight> findByCityTo(String cityTo) {
        if (cityTo == null){
            throw new IllegalArgumentException("Name of city can't be null");
        }
        return flightRepository.findAllByCityTo(cityTo);
    }

    @Override
    public List<Flight> findByCityFrom(String cityFrom) {
        if (cityFrom == null){
            throw new IllegalArgumentException("Name of city can't be null");
        }
        return flightRepository.findAllByCityFrom(cityFrom);
    }

    @Override
    public Flight update(Flight flight) {
        if (flight == null){
            throw new IllegalArgumentException("Flight can't be null");
        }
        return flightRepository.saveAndFlush(flight);
    }
}
