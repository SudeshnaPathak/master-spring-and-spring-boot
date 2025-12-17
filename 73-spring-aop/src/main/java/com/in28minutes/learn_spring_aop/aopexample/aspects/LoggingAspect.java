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

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //Pointcut ~ Where to apply the aspect?
    //execution(* PACKAGE.*.*(..))
    //execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..)) We want to intercept methods calls in business package

    @Before("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))") //Intercept before method execution & apply the aspect
    public void logMethodCall(JoinPoint joinPoint) { //JoinPoint provides details about the method being intercepted
        logger.info("Before Aspect - Method is called - {}", joinPoint);
    }
}
