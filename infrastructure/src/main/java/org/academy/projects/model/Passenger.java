package org.academy.projects.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String passport_number;

    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    public Passenger() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(final String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(final String last_name) {
        this.last_name = last_name;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(final String passport_number) {
        this.passport_number = passport_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passenger{"
                + "first_name='" + first_name
                + '\''
                + ", last_name='" + last_name
                + '\''
                + ", passport_number='" + passport_number
                + '\''
                + ", email='" + email + '\'' +
                '}';
    }
}
