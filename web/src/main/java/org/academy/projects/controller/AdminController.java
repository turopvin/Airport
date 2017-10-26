package org.academy.projects.controller;


import org.academy.projects.controller.dto.FlightRequest;
import org.academy.projects.controller.dto.mapping.FlightRequest2Flight;
import org.academy.projects.model.Flight;
import org.academy.projects.model.Plane;
import org.academy.projects.service.flightManager.FlightManager;
import org.academy.projects.service.planeManager.PlaneManager;
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


    /**
     * Here begins a part deals with Flight operations
     */


    /**
     * Returns page with form to fill for saving new Flight
     * @param flight
     * @param model
     * @return
     */
    @RequestMapping("/savingFlight")
    public String savingFlight(FlightRequest flight, Model model) {
        model.addAttribute("flight", flight );
        return "adminPage/flight/saveFlight";
    }

    /**
     * Returns page with Flight which was registered
     * @param flightRequest
     * @param model
     * @return
     */
    @RequestMapping("/registeringFlight")
    public String registeringFlight(@ModelAttribute FlightRequest flightRequest, Model model){
        final Flight flight = mapper.map(flightRequest);
        flightManager.create(flight);
        model.addAttribute("flight", flight);
        return "adminPage/flight/registeredFlight";
    }

    /**
     * Returns page with form to fill for deleting a Flight
     * @param flight
     * @param model
     * @return
     */
    @RequestMapping("/deletingFlight")
    public  String deletingFlight(Flight flight, Model model){
        model.addAttribute("flight",flight);
        return "adminPage/flight/deleteFlight";
    }

    /**
     * Returns page with Flight which was deleted
     * @param flight
     * @param model
     * @return
     */
    @RequestMapping("/deletedFlight")
    public String deletedFlight(@ModelAttribute Flight flight, Model model){
        final Flight deletedFlight = flightManager.deleteByCityFromAndCityToAndDepartureDate(flight);
        model.addAttribute("flight",deletedFlight);
        return "adminPage/flight/deletedFlight";
    }

    /**
     * Returns page with form to fill to find the Flight
     * @param flight
     * @param model
     * @return
     */
    @RequestMapping("/findingFlight")
    public String findingFlight(Flight flight, Model model){
        model.addAttribute("flight",flight);
        return "adminPage/flight/findFlight";
    }

    /**
     * Returns page with found Flight
     * @return
     */
    @RequestMapping("/foundFlight")
    public String foundFlight(@ModelAttribute Flight flight, Model model){
        final Flight foundFlight = flightManager.findByCityFromAndCityToAndDepartureDate(flight);
        model.addAttribute("flight", foundFlight);
        return "adminPage/flight/foundFlight";
    }

    /**
     * Returns page with updated Flight
     * @param flight
     * @param model
     * @return
     */
    @RequestMapping("/updatedFlight")
    public String updatedFlight(@ModelAttribute Flight flight, Model model){
        final Flight updatedFlight = flightManager.updateFlight(flight);
        System.out.println(flight.getId());
        model.addAttribute("flight", updatedFlight);
        return "adminPage/flight/updatedFlight";
    }


    /**
     * Here begins a part deals with Plane operations
     */
    @RequestMapping("/savingPlane")
    public String savingPlane(Model model){
        model.addAttribute("plane", new Plane());
        return "adminPage/plane/savePlane";
    }

    @RequestMapping("/registeringPlane")
    public String registeringPlane(@ModelAttribute Plane plane, Model model){
        planeManager.create(plane);
        model.addAttribute("plane", plane);
        return "adminPage/plane/registeredPlane";
    }

}
