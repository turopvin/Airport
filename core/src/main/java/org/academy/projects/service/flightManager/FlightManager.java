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

    private final FlightRepository flightRepository;

    @Autowired
    public FlightManager(final FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findAllByCityFromAndCityTo(final Flight flight) {

        if (flight == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return flightRepository.findAllByCityFromAndCityTo(flight.getCityFrom(), flight.getCityTo());
    }

    @Override
    public Flight create(final Flight flight) {

        if (flight == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return flightRepository.save(flight);
    }

    @Override
    public Flight findByCityFromAndCityToAndDepartureDate(final Flight flight) {

        if (flight == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        final Flight foundFlight = flightRepository.findByCityFromAndCityToAndDepartureDate(flight.getCityFrom(),
                flight.getCityTo(), flight.getDepartureDate());

        if (foundFlight == null) {

            throw new IllegalArgumentException("There is no such flight");

        }

        return foundFlight;
    }

    @Override
    public Flight findByID(final Integer id) {

        if (id == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return flightRepository.findById(id);
    }

    @Override
    public Flight buyTicket(final Integer id) {

        if (id == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        Flight flight = flightRepository.findById(id);

        flight.setFreePlaces(flight.getFreePlaces() - 1);

        flightRepository.save(flight);

        return flight;
    }

    @Override
    public Flight deleteByCityFromAndCityToAndDepartureDate(final Flight flight) {

        if (flight == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        final Flight foundFlight = flightRepository.findByCityFromAndCityToAndDepartureDate(flight.getCityFrom(),
                flight.getCityTo(), flight.getDepartureDate());

        flightRepository.deleteByCityFromAndCityToAndDepartureDate(foundFlight.getCityFrom(),
                foundFlight.getCityTo(), foundFlight.getDepartureDate());

        return foundFlight;
    }

    @Override
    public Flight updateFlight(final Flight flight) {

        if (flight == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return flightRepository.save(flight);
    }

    @Override
    public void deleteAllPassedFlight(final Date date) {

        if (date == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        flightRepository.deleteAllByDepartureDateIsBefore(date);
    }

    @Override
    public List<Flight> findAllByCityFrom(final String city) {

        if (city == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return flightRepository.findAllByCityFrom(city);
    }
}
