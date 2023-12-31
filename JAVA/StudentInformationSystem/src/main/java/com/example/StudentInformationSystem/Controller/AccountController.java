package com.example.StudentInformationSystem.Controller;


import com.example.StudentInformationSystem.Entity.Account;
import com.example.StudentInformationSystem.Repository.AccountRepository;
import org.hibernate.engine.spi.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("Account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @PostMapping("insert")
    @ResponseBody
    public ResponseEntity<Account> insertIntoAccount(@RequestBody Account account){
        accountRepository.save(account);
        return ResponseEntity.ok(account);
    }


}
