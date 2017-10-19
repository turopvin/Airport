package org.academy.projects.controller.dto.mapping;

import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.model.Flight;
import org.dozer.loader.api.BeanMappingBuilder;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class FlightRequest2Flight extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(FlightRequest.class, Flight.class,oneWay())
                .fields("cityFrom","cityFrom")
                .fields("cityTo","cityTo")
                .fields("departureDate","departureDate")
                .fields("arrivalDate","arrivalDate")
                .fields("price","price");

    }
}
