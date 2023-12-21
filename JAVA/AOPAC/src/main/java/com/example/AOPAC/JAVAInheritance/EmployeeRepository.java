package com.example.AOPAC.JAVAInheritance;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("emp")
@Repository
@Transactional
public class EmployeeRepository {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @PostMapping("insertFull")
    public void insert(@RequestBody FullTImeEmployee employee){
        em.persist(em.merge(employee));
    }

    @PostMapping("insertPart")
    public void insert(@RequestBody PartTimeEmployee employee){
        em.persist(em.merge(employee));
    }

    @GetMapping("show")
    public List<Employee> ShowAllEmployee(){
        return em.createQuery("Select e from Employee e", Employee.class).getResultList();
    }

}
