package com.example.AOPAC.javaJDBC.entitymanager;

import com.example.AOPAC.javaJDBC.Entity.Course;
import com.example.AOPAC.javaJDBC.Entity.person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("jpql")
public class PersonJPQL {

    @Autowired
     private EntityManager em;



    private  Logger logger= LoggerFactory.getLogger(person.class);


    @GetMapping("all")
    public void jpql_all(){
        Query query=em.createQuery("Select p from person p");
        List resultset = query.getResultList();
        logger.info("all details -> {}",resultset);

    }

    @GetMapping("typed")
    public void jpql_typed(){
        TypedQuery<person> query = em.createQuery("Select p from person p", person.class);
        List<person> resultList= query.getResultList();
        logger.info("all details -> {}",resultList);

    }

    @GetMapping("where")
    public void jpql_where(){
        Query query= em.createQuery("Select c from person c order by size(c.course) desc", person.class);
        List<person> resultList= query.getResultList();
        logger.info("show -> {}",resultList);

    }

    @GetMapping("where2")
    public void jpql_named_where(){
        Query query= em.createNamedQuery("find_by_name", person.class);
        List resultList= query.getResultList();
        logger.info("show -> {}",resultList);

    }
    @GetMapping("where1")
    public void jpql_native_where(){
        Query query= em.createNativeQuery("Select * from person where id = :id", person.class);
        query.setParameter("id", 1);
        List resultList= query.getResultList();
        logger.info("show -> {}",resultList);

    }

}
