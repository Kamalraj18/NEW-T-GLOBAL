package com.example.rest.demorest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class restpost {
    
@GetMapping("display")
public String show(){
    return "classpath:/static/index";
}

}
