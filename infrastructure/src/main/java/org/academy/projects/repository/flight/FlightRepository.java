package org.academy.projects.repository.flight;

import org.academy.projects.model.Flight;
import org.academy.projects.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findAllByCityFromAndCityTo(String from, String to);

    Integer deleteByCityFromAndCityToAndDepartureDate(String cityFrom, String cityTo, Date date);

    Flight findByCityFromAndCityToAndDepartureDate(String cityFrom, String cityTo, Date date);

    Flight findById(Integer id);

    void deleteAllByDepartureDateIsBefore(Date date);

    List<Flight> findAllByCityFrom(String city);

}
