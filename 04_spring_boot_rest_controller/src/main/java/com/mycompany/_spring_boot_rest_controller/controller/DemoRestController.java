package com.mycompany._spring_boot_rest_controller.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class DemoRestController {
    // add code for the "/hello" endpoint

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String sayHello(){
        return "hello";
    }
}
