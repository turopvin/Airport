package org.academy.projects.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "planes")
public class Plane implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="number_of_places")
    private int numberOfPlaces;

    public Integer getID(){
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(final Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    @Override
    public String toString() {
        return "Plane{"
                + "id=" + id
                + ", model='" + model
                + '\''
                + ", numberOfPlaces=" + numberOfPlaces +
                '}';
    }
}
