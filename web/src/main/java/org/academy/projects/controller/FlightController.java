package org.academy.projects.controller;

import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.controller.dto.FlightResponse;
import org.academy.projects.models.Flight;
import org.academy.projects.services.FlightService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class FlightController {

    private final DozerBeanMapper mapper;

    private final FlightService flightService;

    @Autowired
    public FlightController(final DozerBeanMapper mapper,final FlightService flightService){
        this.mapper = mapper;
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity register(@RequestBody @Valid final FlightRequest flightRequest) {

        final Flight flight = mapper.map(flightRequest,Flight.class);

        final Flight registeredFlight = flightService.saveFlight(flight);

        final FlightResponse response = mapper.map(registeredFlight, FlightResponse.class);

        return ResponseEntity.ok().body(response);
    }
}
