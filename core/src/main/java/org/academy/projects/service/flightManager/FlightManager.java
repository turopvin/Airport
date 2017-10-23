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
     * Returns Flights found by cityTo and departureDate
     * @param city
     * @param date
     * @return
     */
    @Override
    public Flight findByCityToAndDepartureDate(String city, Date date) {
        if ((city == null)&&(date == null)) {
            throw new IllegalArgumentException("Flight can't be null");
        }
        return flightRepository.findByCityToAndDepartureDate(city,date);
    }

    /**
     * Delete flight by city cityTo and departure date
     * @param city
     * @param date
     * @return
     */
    @Override
    public Flight deleteByCityToAndDate(String city, Date date) {
        if ((city == null)&&(date == null)) {
            throw new IllegalArgumentException("City or date can't be null");
        }
        final Flight flight = flightRepository.findByCityToAndDepartureDate(city, date);
        flightRepository.deleteByCityToAndDepartureDate(city,date);
        return flight;
    }

    @Override
    public Flight updateFlight(Flight flight){
        if (flight == null){
            throw new IllegalArgumentException("Flight can't be null");
        }

        flightRepository.update(flight.getCityFrom(),flight.getCityTo(),
                flight.getDepartureDate(), flight.getArrivalDate(),
                flight.getPrice(), flight.getPlane(), flight.getId());

        final Flight updatedFlight = flightRepository.findByCityToAndDepartureDate(flight.getCityTo(), flight.getDepartureDate());

        return  updatedFlight;
    }

}
