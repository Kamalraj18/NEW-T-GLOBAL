package com.role.implementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.role.implementation.model.Degree;

public interface DegreeRespository extends JpaRepository<Degree,Integer> {


    Degree findByDname(String dname);
    
}
