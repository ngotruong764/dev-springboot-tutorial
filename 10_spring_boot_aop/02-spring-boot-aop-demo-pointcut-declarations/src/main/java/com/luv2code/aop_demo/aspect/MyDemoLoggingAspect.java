package com.luv2code.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // An Aspect is just a Java class that has a collection of related advices
@Component
@Order(1)
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging

    // Let's start with a @Before advice
    @Before("com.luv2code.aop_demo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("=====>> Executing @Before advice on methods");
    }
}
