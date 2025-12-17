package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    //Simple reusable pointcut configurations
    //If Pointcut expression changes , we need to change only here and not in multiple aspects
    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {} //Maps to pointcut expression above , to be used in other aspects

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut ("bean(*Service*)") //Bean Name Pattern , Intercept beans if their name contains 'Service'
    public void allPackageConfigUsingBean() {}

    @Pointcut ("@annotation(com.in28minutes.learn_spring_aop.aopexample.annotations.TrackTime)") //Annotation based Pointcut ,Intercept methods annotated with @TrackTime
        public void trackTimeAnnotation() {}
}
