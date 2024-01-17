package com.role.implementation.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.role.implementation.model.User;
import com.role.implementation.repository.StudentRepository;
import com.role.implementation.repository.TeacherRepository;
import com.role.implementation.repository.UserRepository;
import com.role.implementation.service.AdminService;
import com.role.implementation.model.Student;
import com.role.implementation.model.Teacher;;


@Controller
@RequestMapping("/adminScreen")
public class AdminController {
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	private AdminService adminService;

	@Autowired
	UserRepository userRepository;
	
	@GetMapping
    public String displayDashboard(Model model){
		String user= returnUsername();
		ArrayList<Student> studList = (ArrayList<Student>) studentRepository.findAll();
        model.addAttribute("userDetails", user);
		model.addAttribute("students", studList);
        return "adminScreen";
    }
	
	@GetMapping("/teacherView")
    public String displayTeacherDashboard(Model model){
		String user= returnUsername();
		ArrayList<Teacher> FacultyList = (ArrayList<Teacher>) teacherRepository.findAll();
        model.addAttribute("userDetails", user);
		model.addAttribute("teachers", FacultyList);
        return "FacultyView";
    }

	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		return users.getName();
	}
	

	   @PostMapping("/search")
    public String searchStudents(@RequestParam String searchTerm, Model model){
        List<Student> searchresults;
        if (StringUtils.hasText(searchTerm)) {
            searchresults = adminService.searchStudents(searchTerm);
        } else {
            searchresults = studentRepository.findAll();
        }
        model.addAttribute("students",searchresults);
        return "adminScreen";
    }

	@PostMapping("/searchFaculty")
    public String searchFacultys(@RequestParam String searchTerm, Model model){
        List<Teacher> searchresults;
        if (StringUtils.hasText(searchTerm)) {
            searchresults = adminService.searchFacultys(searchTerm);
        } else {
            searchresults = teacherRepository.findAll();
        }
        model.addAttribute("teachers",searchresults);
        return "adminScreen/teacherView";
    }




}
