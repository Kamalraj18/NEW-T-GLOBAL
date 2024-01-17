package com.role.implementation.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Teacher")
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq",allocationSize = 1, initialValue = 100)
    private int tid;

    @Column
    private String tname;

    @Column
    private int age;

    @Column
    private String gender;

    @Column
    private String location;

    @Column
    private Long phone_no;


    public Teacher(){

    }

    

}

