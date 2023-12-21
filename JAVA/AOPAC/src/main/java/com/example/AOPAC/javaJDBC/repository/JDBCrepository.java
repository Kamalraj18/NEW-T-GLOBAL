package com.example.AOPAC.javaJDBC.repository;

import com.example.AOPAC.javaJDBC.Entity.person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JDBCrepository extends JpaRepository<person, Integer> {

    person getPersonByid(int id);

    List<person> findByName(String name);
}
