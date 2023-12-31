package com.example.StudentInformationSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name = "student_seq",allocationSize = 1, initialValue = 1)
    private int sid;

    @Column
    private String sname;

    @Column
    private int age;

    @Column
    private String location;

    @Column
    private Long phone_no;

    @ManyToOne
    @JoinColumn(name="degree_id")
    @JsonIgnore
    private Degree degree;

    @Column
    private String Degree_name;

    @OneToOne
    private Account account;
    public Student(){

    }

}
