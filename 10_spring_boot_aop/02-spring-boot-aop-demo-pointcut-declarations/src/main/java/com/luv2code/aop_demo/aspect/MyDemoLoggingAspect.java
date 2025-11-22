package com.luv2code.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // An Aspect is just a Java class that has a collection of related advices
@Component
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging

    // Let's start with a @Before advice
    @Pointcut("execution(* com.luv2code.aop_demo.dao.*.*(..) )")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.aop_demo.dao.*.get*(..))")
    private void forGetter() {}

    @Pointcut("execution(* com.luv2code.aop_demo.dao.*.set*(..))")
    private void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>> Executing @Before advice on methods\n");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("========> Performing API analytics");
    }
}
