package com.example.StudentInformationSystem.Repository;

import com.example.StudentInformationSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    void deleteBysname(String nameOrid);

    @Query(value="SELECT * FROM Student s WHERE " +
            "s.sid LIKE :searchTerm OR " +
            "s.sname LIKE :searchTerm OR " +
            "s.phone_no LIKE:searchTerm OR " +
            "s.Degree_name LIKE :searchTerm OR " +
            "s.location LIKE :searchTerm",nativeQuery = true)
    List<Student> searchStudents(@Param("searchTerm") String searchTerm);

//    @Query(value = "SELECT count(s) FROM Student s WHERE s.degree.name=:name",nativeQuery = true)
    long countByDegreeDegreeName(String name);
}
