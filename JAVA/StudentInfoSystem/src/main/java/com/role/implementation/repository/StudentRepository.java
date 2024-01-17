package com.role.implementation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.role.implementation.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    Student findBysname(String name);

        @Query(value="SELECT * FROM student s WHERE " +
            "CAST(s.sid AS TEXT) LIKE :searchTerm OR " +
            "s.sname LIKE :searchTerm OR " +
            "CAST(s.phone_no AS TEXT) LIKE :searchTerm OR " +
            "s.dname LIKE :searchTerm OR " +
            "s.location LIKE :searchTerm",nativeQuery = true)
    List<Student> searchStudents(@Param("searchTerm") String searchTerm);
    
}
