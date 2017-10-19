package org.academy.projects.controller.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;

public class FlightRequest {

    @NotBlank(message = "can't be empty")
    private String cityFrom;

    @NotBlank(message = "can't be empty")
    private String cityTo;

    @NotBlank(message = "can't be empty")
    private Date departureDate;

    @NotBlank(message = "can't be empty")
    private Date arrivalDate;

    @NotBlank(message = "can't be empty")
    private Integer price;

    @NotBlank(message = "can't be empty")
    private String plane;

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

}
