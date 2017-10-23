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

   List<Flight> findAllByCityTo(String city);
   List<Flight> findAllByCityFrom(String city);
   Integer deleteByCityToAndDepartureDate(String city, Date date);
   Flight findByCityToAndDepartureDate(String city, Date date);

   @Modifying
   @Query("update Flight f set f.cityFrom=?1, f.cityTo=?2, f.departureDate=?3, " +
           "f.arrivalDate=?4, f.price=?5, f.plane=?6 where f.id=?7")
   void update(String cityFrom, String cityTo, Date departureDate,
               Date arrivalDate, Integer price, Plane plane, Integer id);
}
