package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    //Simple reusable pointcut configurations

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {} //Maps to pointcut expression above , to be used in other aspects

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut ("bean(*Service*)") //Bean Name Pattern , simpler way to define pointcut than execution expression
    public void allPackageConfigUsingBean() {}
}
