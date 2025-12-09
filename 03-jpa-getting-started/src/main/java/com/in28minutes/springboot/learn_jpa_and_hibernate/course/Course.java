package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This annotation is used to specify that the class is an entity and this bean is mapped to a database table.
public class Course {
    @Id
    private long id;

//    @Column(name = "name") if the variable name and column name are same then no need to use this annotation
    private String name;

//    @Column(name = "author")
    private String author;

    public Course() {
    }

    public Course(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course[" + "id=" + id + ", name='" + name + ", author='" + author + ']';
    }
}
