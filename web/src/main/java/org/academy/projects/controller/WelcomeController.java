package org.academy.projects.controller;

import org.academy.projects.model.Flight;
import org.academy.projects.service.flightManager.FlightManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Date;


@Controller
public class WelcomeController {


    private final FlightManager flightManager;

    @Autowired
    public WelcomeController(FlightManager flightManager){
        this.flightManager = flightManager;
    }

    @RequestMapping("/")
    public String welcome(){

        java.util.Date date = new java.util.Date();

        flightManager.deleteAllPassedFlifght(date);
        return "welcomePage";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "adminPage/mainAdmin";
    }

    @RequestMapping("/user")
    public String user(Model model){
        model.addAttribute(new Flight());
        return "userPage/mainUser";
    }
}
