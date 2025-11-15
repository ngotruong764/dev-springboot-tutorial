package com.minastik._02_devtools.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String getDailyWorkout(){
        return "Run a hard 5km";
    }

    // expose a new end point for "fortune"
    @RequestMapping(value = "/fortune", method = RequestMethod.GET)
    public String getDailyFortune(){
        return "Today is your lucky day";
    }
}
