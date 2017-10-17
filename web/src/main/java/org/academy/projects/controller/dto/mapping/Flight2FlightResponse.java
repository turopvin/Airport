package org.academy.projects.controller.dto.mapping;

import org.academy.projects.controller.dto.FlightResponse;
import org.academy.projects.models.Flight;
import org.dozer.loader.api.BeanMappingBuilder;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class Flight2FlightResponse extends BeanMappingBuilder {


    @Override
    protected void configure() {
        mapping(Flight.class, FlightResponse.class, oneWay())
                .fields("cityFrom","cityFrom")
                .fields("cityTo","cityTo");
    }
}
