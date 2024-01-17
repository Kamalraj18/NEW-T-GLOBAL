package com.role.implementation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Degree")
@Getter
@Setter
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Degree_seq")
    @SequenceGenerator(name = "Degree_seq",initialValue = 200,allocationSize=1)
    private Long d_id;

    @Column
    private String dname;

    @ManyToMany
    @JoinTable(name="student_degree",joinColumns = @JoinColumn(name="degree_id",referencedColumnName = "d_id"),
    inverseJoinColumns = @JoinColumn(name="Student_id",referencedColumnName = "sid"))
    List<Student> student = new ArrayList<>();
 
    	public List<Student> getStudents() {
		return student;
	}

	public void setStudents(Student student) {
		this.student.add(student);
	}

}
