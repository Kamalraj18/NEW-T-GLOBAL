package com.example.StudentInformationSystem.Controller;

import com.example.StudentInformationSystem.DTO.StudentDegreeDTO;
import com.example.StudentInformationSystem.Entity.Student;
import com.example.StudentInformationSystem.Repository.StudentRepository;
import com.example.StudentInformationSystem.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller

public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("insert")
    @ResponseBody
    public ResponseEntity<String> insertStudentDetails(@RequestBody StudentDegreeDTO studentDegreeDTO) {
        studentService.insertStudentDetails(studentDegreeDTO);
        return ResponseEntity.ok("Successfully inserted");
    }


    @GetMapping("All")
    @ResponseBody
    public List<Student> showAll(){
        List<Student> student = studentRepository.findAll();
        return student;
    }

    @DeleteMapping("delete/{nameOrid}")
    @Transactional
    @ResponseBody
    public ResponseEntity<String> DeleteDetails(@PathVariable String nameOrid) {
        try {
            int id = Integer.parseInt(nameOrid);
             studentRepository.deleteById(id);
             return ResponseEntity.ok("deleted data:"+id);
        } catch (NumberFormatException e) {
            studentRepository.deleteBysname(nameOrid);
            return ResponseEntity.ok("deleted data: "+ nameOrid);
        }
    }


    //web part

    @GetMapping("/showAll")
    public String StudentDetails(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 2;
        Page<Student> students = studentRepository.findAll(PageRequest.of(page,pageSize));
       // model.addAttribute("students",students);
        model.addAttribute("students", students.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", students.getTotalPages());
        return "Home";
    }
    @PostMapping("/search")
    public String searchStudents(@RequestParam String searchTerm, Model model){
        List<Student> searchresults;
        if (StringUtils.hasText(searchTerm)) {
            // Search only if a searchTerm is provided
            searchresults = studentService.searchStudents(searchTerm);
        } else {
            // If no searchTerm, display all students
            searchresults = studentRepository.findAll();
        }
        model.addAttribute("students",searchresults);
        return "Home";
    }

    @GetMapping("/update/{id}")
    public String updateDetails(@PathVariable int id, Model model){
    Student student=studentRepository.findById(id).orElse(null);
    model.addAttribute("update",student);
    return "InsertStudentDetails";
    }

    @PostMapping("/update/{id}")
    public String updateStudentDetails(@PathVariable int id,@ModelAttribute Student student, Model model){
         Student student1=studentRepository.findById(id).orElse(null);
        if(student1 != null){
            student1.setAge(student.getAge());
            student1.setDegree_name(student.getDegree_name());
            student1.setLocation(student.getLocation());
            student1.setPhone_no(student.getPhone_no());
            studentRepository.save(student1);
        }
        return "redirect:/showAll";

    }

    @GetMapping("/studentdashboard")
    public String studentDashBoard(Model model){
        return "Student";
    }
}
