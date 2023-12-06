package com.example.rest.demorest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class restpost {
    
@Autowired
studentrepository repo;

@GetMapping("display")
public String show(){
    return "index";
}

}
