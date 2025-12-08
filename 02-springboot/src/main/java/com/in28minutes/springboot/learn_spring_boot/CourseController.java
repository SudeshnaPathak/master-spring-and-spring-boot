package com.in28minutes.springboot.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController // to define a controller and to handle HTTP requests
public class CourseController {

    @RequestMapping("/courses") // to map HTTP requests to handler methods of MVC and REST controllers
    public List<Course> retrieveAllCourse()
    {
        return Arrays.asList(
                new Course(1 , "Learn AWS" , "in28Minutes"),
                new Course(2 , "Learn DevOps" , "in28Minutes"),
                new Course(3 , "Learn Azure" , "in28Minutes"),
                new Course(4 , "Learn GCP" , "in28Minutes")
        );
    }
}
