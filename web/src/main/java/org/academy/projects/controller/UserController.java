package org.academy.projects.controller;

import org.academy.projects.model.Flight;
import org.academy.projects.model.Passenger;
import org.academy.projects.model.Ticket;
import org.academy.projects.service.flightManager.FlightManager;
import org.academy.projects.service.passengerManager.PassengerManager;
import org.academy.projects.service.ticketManager.TicketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final FlightManager flightManager;

    private final PassengerManager passengerManager;

    private final TicketManager ticketManager;

    @Autowired
    public UserController(FlightManager flightManager,
                          PassengerManager passengerManager,
                          TicketManager ticketManager){
        this.flightManager = flightManager;
        this.passengerManager = passengerManager;
        this.ticketManager = ticketManager;
    }


    @RequestMapping("/findingTrip")
    public String findingTrip(@ModelAttribute Flight flight, Model model){
        final Flight foundFlight = flightManager.findByCityFromAndCityToAndDepartureDate(flight);
        model.addAttribute("flight",foundFlight);
        return "userPage/fullSearch";
    }

    @RequestMapping("/buyTicket")
    public String buyTicket(Integer id,@ModelAttribute Passenger passenger, Model model){
        final Flight flight = flightManager.findByID(id);
        model.addAttribute("flight",flight);
        model.addAttribute("passenger", passenger);
        return "userPage/savePassenger";
    }

    @RequestMapping("/boughtTicket")
    public String boughtTicket(Integer id,
                               @ModelAttribute Passenger passenger, Model model){
        final Passenger registeredPassenger = passengerManager.create(passenger);
        final Flight flight = flightManager.findByID(id);
        System.out.println(flight.getCityFrom()+" "+ flight.getCityTo());
        return "userPage/savedTicket";
    }
}
