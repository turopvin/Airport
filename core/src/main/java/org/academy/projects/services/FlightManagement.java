package org.academy.projects.services;

import org.academy.projects.model.Flight;

import java.util.List;

public interface FlightManagement {

    Flight create(Flight flight);
    void delete(Flight flight);
    List<Flight> findByCityTo(String nameOfCity);
    List<Flight> findByCityFrom(String nameOfCity);
    Flight update(Flight flight);

}
