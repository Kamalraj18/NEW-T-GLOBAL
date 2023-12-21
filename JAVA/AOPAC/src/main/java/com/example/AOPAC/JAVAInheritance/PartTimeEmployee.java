package com.example.AOPAC.JAVAInheritance;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{


    private BigDecimal hourlywage;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(Long id, String name, BigDecimal hourlywage) {
        super(id, name);
        this.hourlywage = hourlywage;
    }
}
