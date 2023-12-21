package com.example.AOPAC.javaJDBC.Controller;

import com.example.AOPAC.javaJDBC.Entity.Passport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passport")
@Transactional
public class PassportController {

    private Logger logger= (Logger) LoggerFactory.getLogger(Passport.class);
    @Autowired
    EntityManager em;


    @PostMapping("insert")
    public String insertAtpassport(@RequestBody Passport passport){
        em.persist(passport);
        return "passport values inserted";
    }

    @GetMapping("show")
    public List<Passport> showAll(){
        Query query=em.createQuery("Select p from Passport p");
        return (List<Passport>) query.getResultList();

    }

    @GetMapping("show/{id}")
    public Passport personDetails(@PathVariable int id){
        Passport passport = em.find(Passport.class, id);
        logger.info("show -> {}",passport);
        logger.info("passport -> {}",passport.getPerson());
        return passport;
    }

    @PutMapping("update/{id}")
    public String updateDetails(@PathVariable int id, @RequestBody Passport passport){
        em.merge(passport);
        return "updated";

    }

    @DeleteMapping("delete/{id}")
    public String deleteDetails(@PathVariable int id){
        Passport passport=em.find(Passport.class,id);
        em.remove(passport);
        return "deleted";
    }

}
