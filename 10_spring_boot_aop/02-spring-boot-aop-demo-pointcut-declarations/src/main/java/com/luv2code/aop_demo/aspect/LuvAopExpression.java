package com.luv2code.aop_demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class LuvAopExpression {
    @Pointcut("execution(* com.luv2code.aop_demo.dao.*.*(..) )")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.aop_demo.dao.*.get*(..))")
    public void forGetter() {}

    @Pointcut("execution(* com.luv2code.aop_demo.dao.*.set*(..))")
    public void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterSetter() {}
}
