package org.academy.projects.service.passengerManager;

import org.academy.projects.model.Passenger;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;

public interface PassengerManagement {

    /**
     * Create new passenger and responsible
     * for not to save the same person twice
     *
     * @param passenger
     * @return
     */
    Passenger create(Passenger passenger);

    /**
     * Delete passenger
     *
     * @param passenger
     */
    void delete(Passenger passenger);

    /**
     * Returns passenger by ID
     *
     * @param id
     * @return
     */
    Passenger read(Integer id);

    /**
     * Returns updated passenger
     *
     * @param passenger
     * @return
     */
    Passenger update(Passenger passenger);

    /**
     * Returns passenger by passport number
     *
     * @param passportNumber
     * @return
     */
    Passenger findByPassportNumber(String passportNumber);


}
