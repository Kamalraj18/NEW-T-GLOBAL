package com.example.StudentInformationSystem.Controller;

import com.example.StudentInformationSystem.Entity.Account;
import com.example.StudentInformationSystem.Entity.Authority;
import com.example.StudentInformationSystem.Entity.Student;
import com.example.StudentInformationSystem.Repository.AccountRepository;
import com.example.StudentInformationSystem.Repository.StudentRepository;
import com.example.StudentInformationSystem.Service.RegistrationService;
import com.example.StudentInformationSystem.Service.StudentService;
import com.example.StudentInformationSystem.util.constants.Previllages;
import com.example.StudentInformationSystem.util.constants.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
public class RegistrationController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AuthorityController authorityController;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping("/registerPage")
    public String registerPageForm(Model model){
    model.addAttribute("Register",new Account());
    return "register";
    }

    @PostMapping("/registerPage")
    @Transactional
    public String registerPage(@ModelAttribute Account account, @ModelAttribute Student student) {
        if (Objects.equals(account.getRole(), "")) {
            account.setRole(Roles.ADMIN.name());
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            Set<Authority> authorities = new HashSet<>();
            authorityController.findById(Previllages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
            authorityController.findById(Previllages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
            account.setAuthorities(authorities);
            accountRepository.save(account);
        } else {
            student.setSname(account.getUsername());
            studentRepository.save(student);
                account.setPassword(passwordEncoder.encode(account.getPassword()));
                accountRepository.save(account);

        }
        return "redirect:/Login";
    }


    @GetMapping("/Login")
    public String LoginForm(Model model)
    {
        return "Login";
    }



}
