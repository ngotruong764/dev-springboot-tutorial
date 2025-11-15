package com.myproject.springcoredemo.rest;

import com.myproject.springcoredemo.common.Coach;
import com.myproject.springcoredemo.common.SwimCoach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define private field for the dependency
    private Coach myCoach;




    /**
     * Constructor injection
     * @Autowire annotation just tell the Spring to inject dependency.
     */
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach myCoach){
        this.myCoach = myCoach;
    }


    /**
     * Setter injection

    @Autowired
    public void SetterInjection(Coach myCoach){
        this.myCoach = myCoach;
    }
     */

    @PostConstruct
    public void DoMyStuff(){
        System.out.println("Do my stuff: "+ myCoach.getClass().getName());
    }

    @RequestMapping(value = "/dailyworkout", method = RequestMethod.GET)
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }



    @PreDestroy
    public void B4Destroy(){
        System.out.println("b4des: "+ myCoach.getClass().getName());
    }
}
