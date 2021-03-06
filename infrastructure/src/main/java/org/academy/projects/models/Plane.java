package org.academy.projects.models;

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


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
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
