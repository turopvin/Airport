package org.academy.projects.service.flightManager;

import org.academy.projects.model.Plane;
import org.academy.projects.repository.flight.FlightRepository;
import org.academy.projects.model.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FlightManager implements FlightManagement {

    private final static Logger log = LoggerFactory.getLogger(FlightManager.class);

    private final FlightRepository flightRepository;

    @Autowired
    public FlightManager(final FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }


    /**
     * Return list of flights
     * by cityFrom and cityTo
     * @param flight
     * @return
     */
    @Override
    public List<Flight> findAllByCityFromAndCityTo(Flight flight) {

        if (flight == null){

            log.error("Flight can't be null "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }

        return flightRepository.findAllByCityFromAndCityTo(flight.getCityFrom(), flight.getCityTo());
    }

    /**
     * Save new flight into database
     * @param flight
     * @return
     */
    @Override
    public Flight create(Flight flight) {
        if (flight == null){

            log.error("Flight can't be null "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }
        return flightRepository.save(flight);
    }


    /**
     * Return flight by cityFrom, cityTo and date
     * @param flight
     * @return
     */
    @Override
    public Flight findByCityFromAndCityToAndDepartureDate(Flight flight) {

        if (flight == null){

            log.error("Flight can't be null in "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }

        return flightRepository.findByCityFromAndCityToAndDepartureDate(flight.getCityFrom(),
                flight.getCityTo(),flight.getDepartureDate());
    }


    /**
     * Return flight by ID
     * @param id
     * @return
     */
    @Override
    public Flight findByID(Integer id) {

        if (id == null) {

            log.error("ID can't be null in "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }

        return flightRepository.findById(id);
    }


    /**
     * Reduce number of free places
     * @param id
     * @return
     */
    @Override
    public Flight buyTicket(Integer id) {

        if (id == null) {

            log.error("ID can't be null in "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }


        Flight flight = flightRepository.findById(id);

        flight.setFreePlaces(flight.getFreePlaces()-1);

        flightRepository.save(flight);

        return flight;
    }

    /**
     * Delete and return flight by
     * cityFrom, cityTo and date
     * @param flight
     * @return
     */
    @Override
    public Flight deleteByCityFromAndCityToAndDepartureDate(Flight flight) {
        if (flight == null) {

            log.error("Flight can't be null in "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }

        final Flight foundFlight = flightRepository.findByCityFromAndCityToAndDepartureDate(flight.getCityFrom(),
                flight.getCityTo(),flight.getDepartureDate());

        flightRepository.deleteByCityFromAndCityToAndDepartureDate(foundFlight.getCityFrom(),
                foundFlight.getCityTo(),foundFlight.getDepartureDate());

        return foundFlight;
    }


    /**
     * Update flight
     * @param flight
     * @return
     */
    @Override
    public Flight updateFlight(Flight flight){

        if (flight == null){

            log.error("Flight can't be null in "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }


        return  flightRepository.save(flight);
    }


    /**
     * Delete all out of date flights
     * @param date
     */
    @Override
    public void deleteAllPassedFlight(Date date) {

        if (date == null) {

            log.error("Date can't be null in "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }

        flightRepository.deleteAllByDepartureDateIsBefore(date);
    }


    /**
     * Return all flights by cityFrom
     * @param city
     * @return
     */
    @Override
    public List<Flight> findAllByCityFrom(String city) {

        if (city == null) {

            log.error("City can't be null in "+FlightManager.class.getName());

            throw new IllegalArgumentException();
        }

        return flightRepository.findAllByCityFrom(city);
    }
}
