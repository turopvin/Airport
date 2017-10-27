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

    private final static Logger log = LoggerFactory.getLogger(PassengerManager.class);

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerManager(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }


    /**
     * Create new passenger and responsible
     * for not to save the same person twice
     * @param passenger
     * @return
     */
    @Override
    public Passenger create(Passenger passenger) {

        if (passenger == null){

            log.error("Passenger can't be null in"+PassengerManager.class.getName());

            throw new IllegalArgumentException();

        }

        if(passengerRepository.findByPassportNumber(passenger.getPassportNumber())!= null){

            return passengerRepository.findByPassportNumber(passenger.getPassportNumber());

        } else return passengerRepository.save(passenger);
    }


    /**
     * Delete passenger
     * @param passenger
     */
    @Override
    public void delete(Passenger passenger) {

        if (passenger == null) {

            log.error("Passenger can't be null in"+PassengerManager.class.getName());

            throw new IllegalArgumentException();
        }

        passengerRepository.delete(passenger);
    }


    /**
     * Returns passenger by ID
     * @param id
     * @return
     */
    @Override
    public Passenger read(Integer id) {

        if (id == null){

            log.error("Id can't be null in"+PassengerManager.class.getName());

            throw new IllegalArgumentException();
        }

        return passengerRepository.findOne(id);
    }


    /**
     * Returns updated passenger
     * @param passenger
     * @return
     */
    @Override
    public Passenger update(Passenger passenger) {

        if (passenger == null) {

            log.error("Passenger can't be null in"+PassengerManager.class.getName());

            throw new IllegalArgumentException();
        }

        return passengerRepository.saveAndFlush(passenger);
    }


    /**
     * Returns passenger by passport number
     * @param passportNumber
     * @return
     */
    @Override
    public Passenger findByPassportNumber(String passportNumber) {

        if (passportNumber == null) {

            log.error("Passport number can't be null in"+PassengerManager.class.getName());

            throw new IllegalArgumentException();
        }

        return passengerRepository.findByPassportNumber(passportNumber);
    }
}
