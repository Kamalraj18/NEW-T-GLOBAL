package com.role.implementation.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.role.implementation.DTO.StudentDegreeDTO;
import com.role.implementation.model.Degree;
import com.role.implementation.model.Student;
import com.role.implementation.model.User;
import com.role.implementation.repository.DegreeRespository;
import com.role.implementation.repository.StudentRepository;
import com.role.implementation.repository.UserRepository;




@Controller
@RequestMapping("/Student")
public class StudentController {
	
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	StudentRepository studentRepository;

    @Autowired
    DegreeRespository degreeRespository;
	
	
	@GetMapping
    public String displayDashboard(Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "dashboard";
    }
	
	String username;

	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
        username=user.getUsername();
		return users.getName();
	}


    @GetMapping("/editdetails")
    @Transactional
    public String editFacultyDetailsForm(Model model){
        User user1 = userRepository.findByEmail(username);
        Student student = studentRepository.findBysname(user1.getName());
        model.addAttribute("students", student);
        System.out.println("userrrrrrrrnameeeeeeeee = "+user1.getName());
        return "StudentDetails";
    }


    @PostMapping("/editdetails")
    @Transactional
    public String editFacultyDetails(@ModelAttribute("students") StudentDegreeDTO studentDegreeDTO, Model model){
        User user1 = userRepository.findByEmail(username);
        Student existingStudent =  studentRepository.findBysname(user1.getName());
        System.out.println("degreeeeeeeeeee = "+studentDegreeDTO.getDname());
        Degree degree = degreeRespository.findByDname(studentDegreeDTO.getDname());
        if(existingStudent != null){
            existingStudent.setAge(studentDegreeDTO.getAge());
            existingStudent.setGender(studentDegreeDTO.getGender());
            existingStudent.setLocation(studentDegreeDTO.getLocation());
            existingStudent.setPhone_no(studentDegreeDTO.getPhone_no());
            existingStudent.setDname(studentDegreeDTO.getDname());
            studentRepository.save(existingStudent);
            if(degree!=null){
            degree.setStudents(existingStudent);
            }
        }
        return "redirect:/Student";
    }
}
