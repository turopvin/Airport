package org.academy.projects.controller.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class FlightRequest {

    @NotBlank(message = "can't be empty")
    private String cityFrom;

    @NotBlank(message = "can't be empty")
    private String cityTo;

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
}
