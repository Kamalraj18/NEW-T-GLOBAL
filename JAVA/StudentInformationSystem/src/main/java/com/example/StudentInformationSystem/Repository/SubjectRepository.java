package com.example.StudentInformationSystem.Repository;

import com.example.StudentInformationSystem.Entity.Subjects;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subjects,Integer> {

    @Query("SELECT DISTINCT s FROM Subjects s LEFT JOIN FETCH s.degreeList")
    List<Subjects> findAllWithDegrees();

}
