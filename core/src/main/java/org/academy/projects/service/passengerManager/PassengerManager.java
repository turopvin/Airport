package org.academy.projects.service.passengerManager;

import org.academy.projects.model.Passenger;
import org.academy.projects.repository.passenger.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PassengerManager implements PassengerManagement {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerManager(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger create(final Passenger passenger) {

        if (passenger == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        if (passengerRepository.findByPassportNumber(passenger.getPassportNumber()) != null) {

            return passengerRepository.findByPassportNumber(passenger.getPassportNumber());

        } else return passengerRepository.save(passenger);
    }

    @Override
    public void delete(final Passenger passenger) {

        if (passenger == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        passengerRepository.delete(passenger);
    }

    @Override
    public Passenger read(final Integer id) {

        if (id == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return passengerRepository.findOne(id);
    }

    @Override
    public Passenger update(final Passenger passenger) {

        if (passenger == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return passengerRepository.saveAndFlush(passenger);
    }

    @Override
    public Passenger findByPassportNumber(final String passportNumber) {

        if (passportNumber == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return passengerRepository.findByPassportNumber(passportNumber);
    }
}
