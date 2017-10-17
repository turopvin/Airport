package org.academy.projects.controller.dto.mapping;

import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.models.Flight;
import org.dozer.loader.api.BeanMappingBuilder;

import java.util.Date;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class FlightRequest2Flight extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(FlightRequest.class, Flight.class,oneWay())
                .fields("cityFrom","cityFrom")
                .fields("cityTo","cityTo");
    }
}
