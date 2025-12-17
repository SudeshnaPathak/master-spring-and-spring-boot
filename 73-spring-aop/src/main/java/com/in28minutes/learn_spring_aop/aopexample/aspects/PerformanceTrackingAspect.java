package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //Do something before and after method execution ~ AROUND Method Execution
//    @Around("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")  //apply to all methods of both business and data package
    @Around("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()") //apply to specific methods annotated with @TrackTime
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { //ProceedingJoinPoint ~ Special JoinPoint that allows us to execute method
        //1.Intercept method call
        //2.Start timer
        long startTimeMillis = System.currentTimeMillis();

        //3.Execute method
        Object returnValue = proceedingJoinPoint.proceed();

        //4.Stop timer
        long endTimeMillis = System.currentTimeMillis();

        long executionDuration = endTimeMillis - startTimeMillis;
        //5.Log execution time
        logger.info("Around Aspect - {} method executed in {} ms" , proceedingJoinPoint , executionDuration );

        //6.Return method's original return value
        return returnValue;
    }
}
