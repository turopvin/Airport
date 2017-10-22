package org.academy.projects.repository.flight;

import org.academy.projects.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

   List<Flight> findAllByCityTo(String city);
   List<Flight> findAllByCityFrom(String city);
}
