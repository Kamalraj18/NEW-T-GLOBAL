package com.example.StudentInformationSystem.Controller;

import com.example.StudentInformationSystem.DTO.SubjectDegreeDTO;
import com.example.StudentInformationSystem.Entity.Degree;
import com.example.StudentInformationSystem.Entity.Subjects;
import com.example.StudentInformationSystem.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("insert")
    @ResponseBody
    public ResponseEntity<String> insertIntoSubject(@RequestBody SubjectDegreeDTO subjectDegreeDTO){
        subjectService.insertIntoSubject(subjectDegreeDTO);
        return ResponseEntity.ok("inserted");
    }

    @GetMapping("show")
    @ResponseBody
    public ResponseEntity<List<Subjects>> getAllSubjectsWithDegrees() {
        List<Subjects> subjectDtoList = subjectService.getAllSubjectsWithDegrees();
        return ResponseEntity.ok(subjectDtoList);
    }


    @GetMapping("/coursepage")
    public String showAllcourses(Model model){
        List<Degree> degrees = subjectService.getAllDegrees();
        model.addAttribute("subjectService", subjectService);
        model.addAttribute("degrees",degrees);
        return "courses";
    }


}
