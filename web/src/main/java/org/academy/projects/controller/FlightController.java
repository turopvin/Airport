package org.academy.projects.controller;

import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.controller.dto.FlightResponse;
import org.academy.projects.model.Flight;
import org.academy.projects.services.FlightManager;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlightController {

    private final DozerBeanMapper mapper;

    private final FlightManager flightManager;

    @Autowired
    public FlightController(final DozerBeanMapper mapper,final FlightManager flightManager){
        this.mapper = mapper;
        this.flightManager = flightManager;
    }

    @RequestMapping("/")
    public String welcomePage(Model model) {
        model.addAttribute(new Flight());
        return "welcome";
    }

    @RequestMapping(value = "/returnPage")
    public String returnPage(@ModelAttribute Flight flight, Model model){
        flightManager.create(flight);
        model.addAttribute("return", flight);
        return "availableFlights";
    }




}
