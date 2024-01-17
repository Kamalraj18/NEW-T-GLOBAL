package com.role.implementation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.role.implementation.model.Student;
import com.role.implementation.model.Teacher;
import com.role.implementation.repository.StudentRepository;
import com.role.implementation.repository.TeacherRepository;

@Service
public class AdminService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

        public List<Student> searchStudents(String searchTerm) {
        return studentRepository.searchStudents("%" + searchTerm + "%");
    }

        public List<Teacher> searchFacultys(String searchTerm) {
            return teacherRepository.searchStudents("%" + searchTerm + "%");
        }

        public void validate() {
            
        }


    
}
