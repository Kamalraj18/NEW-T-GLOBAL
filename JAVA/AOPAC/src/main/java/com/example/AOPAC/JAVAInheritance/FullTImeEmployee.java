package com.example.AOPAC.JAVAInheritance;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class FullTImeEmployee extends Employee{

    private BigDecimal Salary;

    public FullTImeEmployee() {
    }

    public FullTImeEmployee(Long id, String name, BigDecimal Salary) {
        super(id, name);
        this.Salary = Salary;
    }
}
