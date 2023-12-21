package com.example.AOPAC.javaJDBC.Controller;


import com.example.AOPAC.javaJDBC.Entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
@Transactional
public class ReviewController {

    @Autowired
    EntityManager em;

    @GetMapping("show")
    public List<Review> showDetails(){
        Query query=em.createQuery("Select r from Review r");
        return (List<Review>) query.getResultList();
    }

    @PostMapping("insert")
    public String insertReview(@RequestBody Review review){
        review.setCourse(review.getCourse());
        em.persist(review);
        return "review inserted";

    }
}
