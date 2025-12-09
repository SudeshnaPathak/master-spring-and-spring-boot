package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    // CommandLineRunner interface runs the code at the time of application startup

// Uncomment the below code to use JDBC Repository/JPA Repository
//      @Autowired
//      private CourseJdbcRepository repository;
//    @Autowired
//    private  CourseJpaRepository repository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1 , "Learn AWS" , "Sudeshna"));
//        repository.insert(new Course(2 , "Learn Azure" , "Sudeshna"));
//        repository.insert(new Course(3 , "Learn GCP" , "Sudeshna"));
//        repository.deleteById(1);
//        System.out.println(repository.findById(2));
//        System.out.println(repository.findById(3));
//    }

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1 , "Learn AWS" , "Sudeshna"));
        repository.save(new Course(2 , "Learn Azure" , "Sudeshna"));
        repository.save(new Course(3 , "Learn GCP" , "Sudeshna"));
        repository.deleteById(1L);
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
    }
    //JDBC : Write SQL Queries , map ResultSet to Objects
    //JPA : Don't worry about SQL Queries , map Entities to Database tables
    //Spring Data JPA :
    //Here we don't need to talk to EntityManager or write any SQL queries. Spring Data JPA will take care of all these low-level details.
    // We just need to define an interface that extends JpaRepository and Spring Data JPA will provide the implementation automatically at runtime.
    // This is one of the powerful features of Spring Data JPA that simplifies data access in Spring applications.

}
