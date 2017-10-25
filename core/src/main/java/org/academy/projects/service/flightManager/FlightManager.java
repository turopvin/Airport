package org.academy.projects.service.flightManager;

import org.academy.projects.model.Plane;
import org.academy.projects.repository.flight.FlightRepository;
import org.academy.projects.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FlightManager implements FlightManagement {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightManager(final FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    /**
     * Save new flight into database
     * @param flight
     * @return
     */
    @Override
    public Flight create(Flight flight) {
        if (flight == null){
            throw new IllegalArgumentException("Flight can't be null");
        }
        return flightRepository.save(flight);
    }

    /**
     * Returns list of flights found by cityTo
     * @param cityTo
     * @return
     */
    @Override
    public List<Flight> findByCityTo(final String cityTo) {
        if (cityTo == null){
            throw new IllegalArgumentException("Name of city can't be null");
        }
        return flightRepository.findAllByCityTo(cityTo);
    }

    /**
     * Returns list of flights found by cityFrom
     * @param cityFrom
     * @return
     */
    @Override
    public List<Flight> findByCityFrom(final String cityFrom) {
        if (cityFrom == null){
            throw new IllegalArgumentException("Name of city can't be null");
        }
        return flightRepository.findAllByCityFrom(cityFrom);
    }

    /**
     *
     * @param flight
     * @return
     */
    @Override
    public Flight findByCityFromAndCityToAndDepartureDate(Flight flight) {
        if (flight == null){
            throw new IllegalArgumentException("Flight can't be null");
        }
        return flightRepository.findByCityFromAndCityToAndDepartureDate(flight.getCityFrom(),
                flight.getCityTo(),flight.getDepartureDate());
    }

    @Override
    public Flight findByID(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id can't be null");
        }
        return flightRepository.findById(id);
    }

    @Override
    public Flight buyTicket(Integer id) {

        if (id == null) {

            throw new IllegalArgumentException("flight can't be bull");
        }
        Flight flight = flightRepository.findById(id);

        flight.setFreePlaces(flight.getFreePlaces()-1);

        flightRepository.save(flight);

        return flight;
    }

    /**
     *
     * @param flight
     * @return
     */
    @Override
    public Flight deleteByCityFromAndCityToAndDepartureDate(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("flight or date can't be null");
        }

        final Flight foundFlight = flightRepository.findByCityFromAndCityToAndDepartureDate(flight.getCityFrom(),
                flight.getCityTo(),flight.getDepartureDate());
        flightRepository.deleteByCityFromAndCityToAndDepartureDate(foundFlight.getCityFrom(),
                foundFlight.getCityTo(),foundFlight.getDepartureDate());
        return foundFlight;
    }


    @Override
    public Flight updateFlight(Flight flight){
        if (flight == null){
            throw new IllegalArgumentException("Flight can't be null");
        }
        return  flightRepository.saveAndFlush(flight);
    }

}
