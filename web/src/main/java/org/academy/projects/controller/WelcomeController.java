package org.academy.projects.controller;

import org.academy.projects.model.Flight;
import org.academy.projects.service.flightManager.FlightManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {


    private final FlightManager flightManager;

    @Autowired
    public WelcomeController(FlightManager flightManager){
        this.flightManager = flightManager;
    }


    /**
     * Returns welcome page
     * also check the database, if there are out
     * od date flights, this method deletes them
     * @return
     */
    @RequestMapping("/")
    public String welcome(){

        java.util.Date date = new java.util.Date();

        flightManager.deleteAllPassedFlight(date);
        return "welcomePage";
    }


    /**
     * Returns page for admin
     * @return
     */
    @RequestMapping("/admin")
    public String admin(){
        return "adminPage/mainAdmin";
    }


    /**
     * Returns page for user
     * @param model
     * @return
     */
    @RequestMapping("/user")
    public String user(Model model){
        model.addAttribute(new Flight());
        return "userPage/mainUser";
    }
}
