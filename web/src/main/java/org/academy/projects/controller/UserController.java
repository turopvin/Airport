package org.academy.projects.controller;

import org.academy.projects.model.Flight;
import org.academy.projects.service.flightManager.FlightManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final FlightManager flightManager;

    @Autowired
    public UserController(FlightManager flightManager){
        this.flightManager = flightManager;
    }


    @RequestMapping("/findingTrip")
    public String findingTrip(@ModelAttribute Flight flight, Model model){
        flightManager.findByCityFrom(flight.getCityFrom());
        model.addAttribute(flight);
        return "/userPage/resultByDestination";
    }
}
