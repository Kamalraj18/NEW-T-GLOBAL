package com.example.StudentInformationSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDegreeDTO {

    private int id;
    private String name;
    private int age;
    private String location;
    private Long phno;
    private String degree_name;

    public StudentDegreeDTO(int id, String name, int age, String location, Long phno, String degree_name) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
        this.phno = phno;
        this.degree_name = degree_name;
    }


}
