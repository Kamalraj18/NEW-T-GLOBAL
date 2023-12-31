package com.example.StudentInformationSystem.Controller;


import com.example.StudentInformationSystem.Entity.Authority;
import com.example.StudentInformationSystem.Repository.AuthorityRepository;
import com.example.StudentInformationSystem.util.constants.Previllages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorityController {

    @Autowired
    AuthorityRepository authorityRepository;


    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }

    public Optional<Authority> findById(Long id){
        return authorityRepository.findById(id);
    }
}
