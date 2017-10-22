package org.academy.projects.service.flightManager;

import org.academy.projects.model.Flight;

import java.util.List;

public interface FlightManagement {

    Flight create(Flight flight);
    void delete(Flight flight);
    List<Flight> findByCityTo(String nameOfCity);
    List<Flight> findByCityFrom(String nameOfCity);
    Flight find(Integer id);
    Flight update(Flight flight);

}
