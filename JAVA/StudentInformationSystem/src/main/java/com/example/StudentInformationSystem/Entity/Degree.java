package com.example.StudentInformationSystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="degree")
@Getter
@Setter
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "degree_seq")
    @SequenceGenerator(name = "degree_seq",allocationSize = 1,initialValue = 501)
    private int id;

    @Column(name="DegreeName")
    private String degreeName;

    @Column
    @OneToMany(mappedBy = "degree")
    private List<Student> students;



    public Degree() {

    }


}
