package org.academy.projects.controller;


import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.controller.dto.mapping.FlightRequest2Flight;
import org.academy.projects.model.Flight;
import org.academy.projects.model.Plane;
import org.academy.projects.service.flightManager.FlightManager;
import org.academy.projects.service.planeManager.PlaneManager;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {


    private final FlightManager flightManager;

    private final PlaneManager planeManager;

    private final FlightRequest2Flight mapper;

    @Autowired
    public AdminController(final FlightRequest2Flight mapper,
                           final FlightManager flightManager,
                           final PlaneManager planeManager){
        this.mapper = mapper;
        this.flightManager = flightManager;
        this.planeManager = planeManager;
    }

    @RequestMapping("/admin")
    public String admin(){
        return "adminPage/mainAdmin";
    }

    @RequestMapping("/savingFlight")
    public String savingFlight(FlightRequest flight, Model model) {
        model.addAttribute("flight", flight );
        return "adminPage/saveFlight";
    }

    @RequestMapping("/registeringFlight")
    public String registeringFlight(@ModelAttribute FlightRequest flightRequest, Model model){
        final Flight flight = mapper.map(flightRequest);
        flightManager.create(flight);
        model.addAttribute("flight", flight);
        return "adminPage/registeredFlight";
    }

    @RequestMapping("/savingPlane")
    public String savingPlane(Model model){
        model.addAttribute("plane", new Plane());
        return "adminPage/savePlane";
    }

    @RequestMapping("/registeringPlane")
    public String registeringPlane(@ModelAttribute Plane plane, Model model){
        planeManager.create(plane);
        model.addAttribute("plane", plane);
        return "adminPage/registeredPlane";
    }




}
