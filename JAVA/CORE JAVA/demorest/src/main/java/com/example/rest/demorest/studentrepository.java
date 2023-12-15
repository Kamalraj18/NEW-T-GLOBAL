package com.example.rest.demorest;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentrepository extends JpaRepository<studententity,Integer> {

    List<studententity> findBysname(String sname);
    
}
