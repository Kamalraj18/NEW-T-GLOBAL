package com.example.AOPAC.javaJDBC.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "passport_seq")
    @SequenceGenerator(name = "passport_seq", sequenceName = "passport_seq", allocationSize = 1, initialValue = 5000)
    private int p_id;
    @Column
    private String p_number;

    @OneToOne(fetch = FetchType.LAZY)
    private person Person;

public Passport(){}
    public Passport(int p_id, String p_number) {
        this.p_id = p_id;
        this.p_number = p_number;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }

    public person getPerson() {
        return Person;
    }

    public void setPerson(person person) {
        Person = person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "p_id=" + p_id +
                ", p_number='" + p_number + '\'' +
                ", Person=" + Person +
                '}';
    }

}
