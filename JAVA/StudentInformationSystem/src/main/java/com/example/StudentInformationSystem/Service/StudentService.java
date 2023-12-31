package com.example.StudentInformationSystem.Service;

import com.example.StudentInformationSystem.DTO.StudentDegreeDTO;
import com.example.StudentInformationSystem.Entity.Degree;
import com.example.StudentInformationSystem.Entity.Student;
import com.example.StudentInformationSystem.Repository.DegreeRepository;
import com.example.StudentInformationSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DegreeRepository degreeRepository;

    public void insertStudentDetails(StudentDegreeDTO student) {
        String degreeName = student.getDegree_name();
        //Degree degree = degreeRepository.findById(student.getDegree_id()).orElse(null);
        Degree degree = (Degree) degreeRepository.findByDegreeName(degreeName).orElse(null);
        if (degree != null) {
            Student student1 = new Student();
            student1.setSid(student.getId());
            student1.setSname(student.getName());
            student1.setAge(student.getAge());
            student1.setLocation(student.getLocation());
            student1.setPhone_no(student.getPhno());
            student1.setDegree_name(student.getDegree_name());
            student1.setDegree(degree);


            degreeRepository.save(degree);
            studentRepository.save(student1);

        }
    }

    public List<Student> searchStudents(String searchTerm) {
        return studentRepository.searchStudents("%" + searchTerm + "%");
    }
}





