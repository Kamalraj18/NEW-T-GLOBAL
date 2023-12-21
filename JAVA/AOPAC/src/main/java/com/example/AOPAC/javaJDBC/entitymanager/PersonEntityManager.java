package com.example.AOPAC.javaJDBC.entitymanager;

import com.example.AOPAC.javaJDBC.Entity.Course;
import com.example.AOPAC.javaJDBC.Entity.person;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("entity")
@Transactional
public class PersonEntityManager {

    private Logger logger=LoggerFactory.getLogger(person.class);
    @Autowired
    EntityManager em; //this is by importing entity manager class -> 2

    @GetMapping("Alldata/{id}")
    public person personDetails(@PathVariable int id){
         person Person = em.find(person.class, id);
         logger.info("show -> {}",Person);
         logger.info("passport -> {}",Person.getPassport());
        return Person;
    }


    @DeleteMapping("delete/{id}")
    public void deleteDetails(@PathVariable int id){
        person Person = em.find(person.class,id);
        em.remove(Person);
    }

    @PostMapping("insert")
    public String insertdata(@RequestBody person Person){
        Person.setCreatedDate(LocalDateTime.now());
        em.persist(Person);
        return "data inserted";
    }

    @PutMapping("update/{id}")
    public String updateDetails(@PathVariable int id, @RequestBody person Person){
        Person.setUpdatedDate(LocalDateTime.now());
        em.merge(Person);
        logger.info("updated");
        return "updated successfully";

    }

//    @PostMapping("i")
//    public void playWithEntityManager(){
//        person Person=new person(155,"D","Delhi",25);
//        em.persist(Person);
//        person Person1=new person(156,"E","Egmore",26);
//        em.persist(Person1);
//        em.flush();
//        Person.setLocation("Dharshan");
//        Person1.setLocation("Ernakulam");
//
//    }


//--------------------MANY TO MANY--------------------------------------

@GetMapping("retrieveall/{id}")
    public void retrieveall(@PathVariable int id){
        person Person = em.find(person.class,id);
        logger.info("show student -> {}",Person);
        logger.info("show -> {}", Person.getCourse());

}

@PostMapping("insertall")
    public void insertall(@RequestBody person Person, @RequestBody Course course){
        Person.addCourse(course);
        course.addPerson(Person);
}


















//em.refresh - used to discard any current changes done
//em.flush - when we use persist or merge the changes might not immediately stored in the db, flush will be make that to be queued in persistence context
//em.detach - detach(entityname) are untracked by the database
//em.clear - after clear() none of the entity will be tracked everything will be detached with the scope
}
