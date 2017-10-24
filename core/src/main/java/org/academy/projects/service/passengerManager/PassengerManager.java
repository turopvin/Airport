package org.academy.projects.service.passengerManager;

import org.academy.projects.model.Passenger;
import org.academy.projects.repository.passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PassengerManager implements PassengerManagement {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerManager(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger create(Passenger passenger) {
        if (passenger == null){
            throw new IllegalArgumentException("Passenger can't be null");
        }
        return passengerRepository.save(passenger);
    }

    @Override
    public void delete(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger can't be null");
        }
        passengerRepository.delete(passenger);
    }

    @Override
    public Passenger read(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("id can't be null");
        }
        return passengerRepository.findOne(id);
    }

    @Override
    public Passenger update(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("passenger can't be null");
        }
        return passengerRepository.saveAndFlush(passenger);
    }
}
