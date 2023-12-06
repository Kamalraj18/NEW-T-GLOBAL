package com.example.rest.demorest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class studententity {

    @Id    
    private int id;
    private String sname;
    private int age;


    
    public studententity() {
    }
    public studententity(int id, String sname, int age) {
        this.id = id;
        this.sname = sname;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    
}
