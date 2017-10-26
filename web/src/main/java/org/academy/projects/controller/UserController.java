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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

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


    /**
     * Returns a page with form to fill
     * to see schedule
     * @param model
     * @return
     */
    @RequestMapping("/showSchedule")
    public String showSchedule(Model model){
        model.addAttribute("flight", new Flight());
        return "userPage/findSchedule";
    }

    /**
     * Returns a page with schedule
     * @param flight
     * @param model
     * @return
     */
    @RequestMapping("/schedule")
    public String schedule(@ModelAttribute Flight flight, Model model){
        final List<Flight> flights = flightManager.findAllByCityFromAndCityTo(flight);
        model.addAttribute("flight", flights);
        return "userPage/schedule";
    }

    /**
     * Returns page with form to fill
     * (passport number) to find list of tickets
     * @param model
     * @return
     */
    @RequestMapping("/showTickets")
    public String showTickets(Model model){
        model.addAttribute("passenger", new Passenger());

        return "userPage/formToFindMyTickets";
    }

    /**
     *Returns list of tickets
     * @param passenger
     * @param model
     * @return
     */
    @RequestMapping("/myTickets")
    public String myTickets(@ModelAttribute Passenger passenger, Model model){

        final Passenger foundPassenger = passengerManager.findByPassportNumber(passenger.getPassportNumber());

        final Set<Ticket> tickets = foundPassenger.getTickets();

        model.addAttribute("ticket", tickets);

        return "userPage/myFoundTickets";
    }

    /**
     * Returns a form to fill to find a flight
     * @param model
     * @return
     */
    @RequestMapping("/findFlight")
    public String findFlight(Model model){
        model.addAttribute(new Flight());
        return "userPage/formToSearch";
    }

    /**
     * Returns page with found flight
     * @param flight
     * @param model
     * @return
     */
    @RequestMapping("/findingTrip")
    public String findingTrip(@ModelAttribute Flight flight, Model model){

        Flight foundFlight = flightManager.findByCityFromAndCityToAndDepartureDate(flight);

        if (foundFlight == null) {
            return "userPage/noSuchFlight";
        }
        if (foundFlight.getFreePlaces() == 0){
            return "userPage/noFreeSeats";
        }

        foundFlight = flightManager.buyTicket(foundFlight.getId());

        model.addAttribute("flight",foundFlight);

        return "userPage/fullSearch";
    }

    /**
     * Retutrns a form for registering new passenger
     * @param id
     * @param passenger
     * @param model
     * @return
     */
    @RequestMapping("/buyTicket")
    public String buyTicket(Integer id,@ModelAttribute Passenger passenger, Model model){

        final Flight flight = flightManager.findByID(id);

        model.addAttribute("flight",flight);

        model.addAttribute("passenger", passenger);

        return "userPage/savePassenger";
    }

    /**
     * Returns a page with new saved ticket
     * @param id
     * @param passenger
     * @param model
     * @return
     */
    @RequestMapping("/boughtTicket/{id}")
    public String boughtTicket(@PathVariable("id") Integer id,
                               @ModelAttribute Passenger passenger, Model model){
        final Passenger registeredPassenger = passengerManager.create(passenger);

        final Flight flight = flightManager.findByID(id);

        final Ticket ticket = new Ticket();

        ticket.setFlight(flight);

        ticket.setPassenger(registeredPassenger);

        ticketManager.create(ticket);

        model.addAttribute("ticket",ticket);

        return "userPage/savedTicket";
    }
}
