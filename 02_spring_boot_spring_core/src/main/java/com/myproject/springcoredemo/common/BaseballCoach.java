package com.myproject.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In Constructor: "+this.getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spending 30 minutes in batting practice";
    }
}
