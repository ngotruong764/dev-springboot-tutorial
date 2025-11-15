package com.minastik._02_devtools.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coach_name;

    @Value("${team.name}")
    private String team_name;


    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String getDailyWorkout(){
        return "Run a hard 5km";
    }

    // expose a new end point for "fortune"
    @RequestMapping(value = "/fortune", method = RequestMethod.GET)
    public String getDailyFortune(){
        return "Today is your lucky day";
    }

    @RequestMapping(value="/team", method=RequestMethod.GET)
    public String team(){
        return "Coach name: "+ coach_name+ "- Team name: "+team_name;
    }
}
