package com.mycompany._thymeleaf_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // new  controller method to show initial HTML form

    @RequestMapping(value="/showForm",method = RequestMethod.GET)
    public String showForm(){
        return "helloworld-form";
    }
    // need a controller method to process the HTML form
    @RequestMapping(value = "/processForm", method = RequestMethod.GET)
    public String processForm(){
        return "helloworld";
    }

    // new controller method to read form data and add data to the model
    @RequestMapping(value = "/processFormVersionTwo", method = RequestMethod.GET)
    public String letsShoutDude(HttpServletRequest request, Model model){
        // read the request parameter from the HTML form
        String name = request.getParameter("studentName");

        // convert the data to all caps
        name = name.toUpperCase();

        // create the message
        String message = "Yo! "+ name;

        // add message to the model
        model.addAttribute("message", message);
        return "helloworld";
    }

    @RequestMapping(value = "/processFormVersionThree", method = RequestMethod.POST)
    public String processFormVersionThree(@RequestParam(name = "studentName") String name, Model model){

        // convert the data to all caps
        name = name.toUpperCase();

        // create the message
        String message = " Version 3 = Yo! "+ name;

        // add message to the model
        model.addAttribute("message", message);
        return "helloworld";
    }
}
