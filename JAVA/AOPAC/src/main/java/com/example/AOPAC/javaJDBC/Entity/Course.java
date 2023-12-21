package com.example.AOPAC.javaJDBC.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "your_entity_seq")
    @SequenceGenerator(name = "your_entity_seq", sequenceName = "your_entity_seq", allocationSize = 1, initialValue = 100)
    @Column(name = "Cid")
    private int c_id;
    @Column
    private String c_name;

    @OneToMany
    @JsonManagedReference
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    private List<person> Person = new ArrayList<>();
    public Course() {
     }

    public Course(int c_id, String c_name) {
        this.c_id = c_id;
        this.c_name = c_name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public List<Review> getReview() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {

        this.reviews.add(review);
    }

    public void deleteReview(Course course){
        this.reviews.remove(course);
    }

    public List<person> getPerson() {
        return Person;
    }

    public void addPerson(person Person) {
        this.Person.add(Person);
    }

    @Override
    public String toString() {
        return "Course{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                '}';
    }
}
