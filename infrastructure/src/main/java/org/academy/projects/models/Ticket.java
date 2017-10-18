package org.academy.projects.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(final Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(final Flight flight) {
        this.flight = flight;
    }
}
