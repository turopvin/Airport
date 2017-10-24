package org.academy.projects.service.passengerManager;

import org.academy.projects.model.Passenger;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;

public interface PassengerManagement {

    Passenger create(Passenger passenger);
    void delete(Passenger passenger);
    Passenger read(Integer id);
    Passenger update(Passenger passenger);

}
