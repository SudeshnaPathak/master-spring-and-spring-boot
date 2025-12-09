package com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    //Naming Convention for custom query methods - findBy<PropertyName>
     List<Course> findByAuthor(String author);
     List<Course> findByName(String name);
}
