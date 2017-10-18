package org.academy.projects.controller;

import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.controller.dto.FlightResponse;
import org.academy.projects.models.Flight;
import org.academy.projects.services.FlightService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class FlightController {

    private final DozerBeanMapper mapper;

    private final FlightService flightService;

    @Autowired
    public FlightController(final DozerBeanMapper mapper,final FlightService flightService){
        this.mapper = mapper;
        this.flightService = flightService;
    }

    @RequestMapping("/")
    public String welcomePage() {
        return "welcome";
    }




}
