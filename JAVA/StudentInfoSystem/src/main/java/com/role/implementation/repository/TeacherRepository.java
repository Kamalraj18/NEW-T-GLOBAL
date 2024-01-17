package com.role.implementation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.role.implementation.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

    Teacher findBytname(String name);

           @Query(value="SELECT * FROM teacher t WHERE " +
            "CAST(t.tid AS TEXT) LIKE :searchTerm OR " +
            "t.tname LIKE :searchTerm OR " +
            "CAST(t.phone_no AS TEXT) LIKE :searchTerm OR " +
            "t.location LIKE :searchTerm",nativeQuery = true)
    List<Teacher> searchStudents(@Param("searchTerm") String searchTerm);
    
    
}
