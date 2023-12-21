package com.example.AOPAC.javaJDBC.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
@NamedQueries(value = {
        @NamedQuery(name = "find_by_name",query = "select p from person p where p.name like 'C'")
})
public class person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private String location;

    @Column(nullable = false)
    private int age;

    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Passport passport;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name="Persons_Courses")

    //JoinColumns,inverseJoinColumns are the set value name for each table id
    private List<Course> course = new ArrayList<>();
    public person(){}

    public person(int id, String name, String location, int age, Passport passport) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.age = age;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void addCourse(Course course) {
        this.course.add(course);
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", age=" + age +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", passport=" + passport +
                '}';
    }
}
