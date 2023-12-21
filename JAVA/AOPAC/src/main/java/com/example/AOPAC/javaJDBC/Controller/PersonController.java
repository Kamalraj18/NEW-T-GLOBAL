package com.example.AOPAC.javaJDBC.Controller;


import com.example.AOPAC.javaJDBC.Entity.person;
import com.example.AOPAC.javaJDBC.repository.JDBCrepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private JDBCrepository jdbCrepository; //this is based JpaRepostiory inteface -> 1


    @GetMapping("All")
    public List<person> personList(){
        Sort sort =Sort.by(Sort.Direction.DESC,"name");
        logger.info("This is an informational message.");
        return jdbCrepository.findAll(sort);

    }

    @GetMapping("find/{nameOrId}")
    public Object getdetailsByName(@PathVariable String nameOrId) {
        try {
            int id = Integer.parseInt(nameOrId);
            return jdbCrepository.findById(id);
        } catch (NumberFormatException e) {
            return jdbCrepository.findByName(nameOrId);
        }
    }
    @PostMapping("insert")
    public person insertdata(@RequestBody person Person){
        Person.setCreatedDate(LocalDateTime.now());
        jdbCrepository.save(Person);
        logger.info("Data stored successfully");
        return Person;
    }

    @DeleteMapping("delete/{id}")
    public String deletebyid(@PathVariable("id") int id){
        jdbCrepository.deleteById(id);
        logger.info("data deleted");
        return "deleted";
    }

    @PutMapping("update/{id}")
    public person updateData(@PathVariable int id, @RequestBody person Person){
        person existingperson = jdbCrepository.getPersonByid(id);
        existingperson.setUpdatedDate(LocalDateTime.now());
        if(existingperson != null) {
            existingperson.setName(Person.getName());
            existingperson.setLocation(Person.getLocation());
            existingperson.setAge(Person.getAge());
            existingperson.setPassport(Person.getPassport());
            jdbCrepository.save(existingperson);
            logger.info("update successfully");
        }
return existingperson;
    }

    @GetMapping("page")
    public Page<person> pageresult(){
        PageRequest pageRequest = PageRequest.of(0,2);
        logger.info("This is an informational message.");
        return (Page<person>) jdbCrepository.findAll(pageRequest);

    }


}
