package com.example.AOPAC.javaJDBC.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Entity
@Table(name="Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "review_seq")
    @SequenceGenerator(name = "review_seq", sequenceName = "review_seq", allocationSize = 1, initialValue = 2000)
    private int r_id;
    @Min(value = 1,message = "the minimum value is 1")
    @Max(value = 5,message = "the maximum value is 5")
    @Column
    private int rating;

    @Column
    private String Description;

    @ManyToOne
    @JsonBackReference
    private Course course;

    public Review(){}

    public Review(int r_id, int rating, String description, Course course) {
        this.r_id = r_id;
        this.rating = rating;
        Description = description;
        this.course = course;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
