package org.academy.projects.service.flightManager;

import org.academy.projects.model.Flight;
import org.academy.projects.model.Plane;

import java.util.Date;
import java.util.List;

public interface FlightManagement {

    /**
     * Save new flight into database
     *
     * @param flight
     * @return
     */
    Flight create(Flight flight);

    /**
     * Return list of flights
     * by cityFrom and cityTo
     *
     * @param flight
     * @return
     */
    List<Flight> findAllByCityFromAndCityTo(Flight flight);

    /**
     * Update flight
     *
     * @param flight
     * @return
     */
    Flight updateFlight(Flight flight);

    /**
     * Delete and return flight by
     * cityFrom, cityTo and date
     *
     * @param flight
     * @return
     */
    Flight deleteByCityFromAndCityToAndDepartureDate(Flight flight);

    /**
     * Return flight by cityFrom, cityTo and date
     *
     * @param flight
     * @return
     */
    Flight findByCityFromAndCityToAndDepartureDate(Flight flight);

    /**
     * Return flight by ID
     *
     * @param id
     * @return
     */
    Flight findByID(Integer id);

    /**
     * Reduce number of free places
     *
     * @param id
     * @return
     */
    Flight buyTicket(Integer id);

    /**
     * Delete all out of date flights
     *
     * @param date
     */
    void deleteAllPassedFlight(Date date);

    /**
     * Return all flights by cityFrom
     *
     * @param city
     * @return
     */
    List<Flight> findAllByCityFrom(String city);

}
