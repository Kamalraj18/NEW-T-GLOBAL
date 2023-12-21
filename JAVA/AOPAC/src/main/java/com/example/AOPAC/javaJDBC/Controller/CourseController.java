package com.example.AOPAC.javaJDBC.Controller;

import com.example.AOPAC.javaJDBC.Entity.Course;
import com.example.AOPAC.javaJDBC.Entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.annotations.TypeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@Transactional
public class CourseController {

    @Autowired
    EntityManager em;

    @GetMapping("show")
    public List<Course> showAll(){
        Query query = em.createQuery("select c from Course c");
        return (List<Course>) query.getResultList();



    }

    @PostMapping("insert")
    public String insertCourse(@RequestBody Course course){
        em.persist(course);
        return "inserted";
    }

    @PostMapping("insertreview")
    public String insertReview(@RequestBody Review review){
        em.persist(review);
        return "review inserted";
    }

    @DeleteMapping("delete/{id}")
    public void deletedetails(@PathVariable int id){
        Review review=em.find(Review.class,id);
        em.remove(review);

    }

}
