package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {

        //JoinPoint ~ Details of the method being intercepted
        //JoinPoint ~ When pointcut condition is true, the advice is executed. A specific execution instance of advice is called a join point.

        //Advice ~ What code to execute?
        logger.info("Before Aspect - {} is called with arguments: {}", joinPoint , joinPoint.getArgs());
    }

    @After("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))") //Intercept after the method executes successfully or throws an exception
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))",
            throwing = "exception"
    ) //Intercept only after the method throws an exception
    public void logMethodCallAfterException(JoinPoint joinPoint , Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown exception", joinPoint , exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))",
            returning = "resultValue"
    ) //Intercept only after the method executes successfully
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint , Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned value: {}", joinPoint , resultValue);
    }


}
