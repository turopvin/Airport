package org.academy.projects.controller;

import org.academy.projects.model.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(){
        return "welcomePage";
    }

    @RequestMapping("/login")
    public String login(){
        return "adminPage/loginAdmin";
    }

    @RequestMapping("/user")
    public String user(Model model){
        model.addAttribute(new Flight());
        return "userPage/mainUser";
    }
}
