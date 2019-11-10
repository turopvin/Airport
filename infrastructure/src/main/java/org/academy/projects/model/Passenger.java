package org.academy.projects.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "passenger", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Set<Ticket> tickets;

    public Passenger() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(final String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "Passenger{"
                + "firstName='" + firstName
                + '\''
                + ", lastName='" + lastName
                + '\''
                + ", passportNumber='" + passportNumber
                + '\''
                + ", email='" + email + '\'' +
                '}';
    }
}
