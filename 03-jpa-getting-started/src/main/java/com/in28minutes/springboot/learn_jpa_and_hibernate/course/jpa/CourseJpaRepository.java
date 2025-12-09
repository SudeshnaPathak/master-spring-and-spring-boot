package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional // EntityManager operations should be executed within a transaction context.
public class CourseJpaRepository {

    @PersistenceContext // It is used to inject an EntityManager instance.
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

}
