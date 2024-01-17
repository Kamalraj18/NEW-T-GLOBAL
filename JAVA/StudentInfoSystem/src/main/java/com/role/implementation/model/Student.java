package com.role.implementation.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;
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
    private String gender;

    @Column
    private String location;

    @Column
    private String dname;

    @Column
    private Long phone_no;

    @ManyToMany(mappedBy = "student")
    private List<Degree> degrees;

    public Student(){

    }



}

