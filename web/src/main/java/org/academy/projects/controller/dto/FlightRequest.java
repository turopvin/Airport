package org.academy.projects.controller.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class FlightRequest {

    private String cityFrom;

    private String cityTo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;

    private Integer price;

    private Integer plane;

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

    public Integer getPlane() {
        return plane;
    }

    public void setPlane(Integer plane) {
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "FlightRequest{" +
                "cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", price='" + price + '\'' +
                ", plane='" + plane + '\'' +
                '}';
    }
}
