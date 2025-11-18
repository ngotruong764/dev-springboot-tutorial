package com.luv2code.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // An Aspect is just a Java class that has a collection of related advices
@Component
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging

    // Let's start with a @Before advice
//    @Before("execution(public void add*())")
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>> Executing @Before advice on methods\n");
    }
}
