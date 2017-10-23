package org.academy.projects.service.flightManager;

import org.academy.projects.model.Flight;
import org.academy.projects.model.Plane;

import java.util.Date;
import java.util.List;

public interface FlightManagement {

    Flight create(Flight flight);

    Flight findByCityToAndDepartureDate(String city, Date date);

    List<Flight> findByCityTo(String nameOfCity);

    List<Flight> findByCityFrom(String nameOfCity);

    Flight updateFlight(Flight flight);

    Flight deleteByCityToAndDate(String city, Date date);

}
