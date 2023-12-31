package com.example.StudentInformationSystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="subject")
@Getter
@Setter
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "subject_seq")
    @SequenceGenerator(name = "subject_seq",allocationSize = 1,initialValue = 601)
    private int subject_id;

    @Column
    private String subject_name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "subject_degree_association",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Degree> degreeList;





}
