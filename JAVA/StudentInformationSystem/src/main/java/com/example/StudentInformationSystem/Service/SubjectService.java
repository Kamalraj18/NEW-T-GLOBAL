package com.example.StudentInformationSystem.Service;

import com.example.StudentInformationSystem.DTO.DegreeDTo;
import com.example.StudentInformationSystem.DTO.SubjectDegreeDTO;
import com.example.StudentInformationSystem.Entity.Degree;
import com.example.StudentInformationSystem.Entity.Subjects;
import com.example.StudentInformationSystem.Repository.DegreeRepository;
import com.example.StudentInformationSystem.Repository.StudentRepository;
import com.example.StudentInformationSystem.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DegreeRepository degreeRepository;
    @Autowired
    SubjectRepository subjectRepository;
    public void insertIntoSubject(SubjectDegreeDTO subjectDegreeDTO) {
        Subjects subject = new Subjects();
        subject.setSubject_id(subjectDegreeDTO.getSubject_id());
        subject.setSubject_name(subjectDegreeDTO.getSubject_name());
        List<DegreeDTo> degreeIds = subjectDegreeDTO.getDegreeList();
        List<Degree> degree = degreeRepository.findAllByIdIn(degreeIds);
        subject.setDegreeList(degree);

        // Save the subject
        subjectRepository.save(subject);

    }


    public List<Subjects> getAllSubjectsWithDegrees() {
        return subjectRepository.findAll();
    }

    public List<Degree> getAllDegrees() {
        return degreeRepository.findAll();
    }

    public long getStudentCountByDegree(String name){
        return studentRepository.countByDegreeDegreeName(name);
    }
}
