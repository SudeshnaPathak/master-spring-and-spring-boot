package com.in28minutes.learn_spring_aop.aopexample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Flexibility of specific methods opting in for tracking time instead of all methods in a class or package can be obtained using custom annotations
@Target(ElementType.METHOD) //Can be applied to methods
@Retention(RetentionPolicy.RUNTIME) //Available at runtime
public @interface TrackTime {
}
