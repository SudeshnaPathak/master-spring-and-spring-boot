package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect // Indicates this class contains AOP configurations
public class LoggingAspect {

    //Aspect = Pointcut + Advice
    private final Logger logger = LoggerFactory.getLogger(getClass());

    //Pointcut ~ Where to apply the aspect?
    //execution(* PACKAGE.*.*(..))
    //execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..)) Where? ~ We want to intercept methods calls in business package

    @Before("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))") //When? ~ Intercept before method execution
    public void logMethodCall(JoinPoint joinPoint) { //JoinPoint ~ Details of the method being intercepted

        //JoinPoint ~ When pointcut condition is true, the advice is executed. A specific execution instance of an advice is called a join point.

        //Advice ~ What code to execute?
        logger.info("Before Aspect - {} is called with arguments: {}", joinPoint , joinPoint.getArgs());
    }
}
