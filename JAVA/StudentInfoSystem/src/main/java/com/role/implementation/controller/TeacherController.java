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

import com.role.implementation.model.Teacher;
import com.role.implementation.model.User;
import com.role.implementation.repository.TeacherRepository;
import com.role.implementation.repository.UserRepository;




@Controller
@RequestMapping("/Teacher")
public class TeacherController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;


    @GetMapping
    public String displayDashboard(Model model){
        String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "teacherdashboard";
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
        Teacher teacher = teacherRepository.findBytname(user1.getName());
        model.addAttribute("facultys", teacher);
        System.out.println("userrrrrrrrnameeeeeeeee = "+user1.getName());
        return "FacultyDetails";
    }

    @PostMapping("/editdetails")
    @Transactional
    public String editFacultyDetails(@ModelAttribute("facultys") Teacher teacher, Model model){
        User user1 = userRepository.findByEmail(username);
        Teacher exisitingTeacher =  teacherRepository.findBytname(user1.getName());
        if(exisitingTeacher !=null){
            exisitingTeacher.setAge(teacher.getAge());
            exisitingTeacher.setGender(teacher.getGender());
            exisitingTeacher.setLocation(teacher.getLocation());
            exisitingTeacher.setPhone_no(teacher.getPhone_no());
            teacherRepository.save(exisitingTeacher);
        }
        return "redirect:/Teacher";
    }


}
