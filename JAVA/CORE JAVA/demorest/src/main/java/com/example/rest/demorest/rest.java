package com.example.rest.demorest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class rest {
    
    @Autowired
    studentrepository student;

    @GetMapping("details")
    @ResponseBody
    public List<studententity> showdetails(){
        List<studententity> s = student.findAll();
        return s;
    }

    @GetMapping("details/{id}")
    @ResponseBody
    public studententity showdetailsbyid(@PathVariable("id") int id){
        studententity s = student.findById(id).orElse(new studententity(0,"",0));
        return s;
    }

    @GetMapping("getpath{id}/{idd}")
    @ResponseBody
    public String getdetails(@PathVariable("id") int i,@PathVariable("idd") int j){
        String s=Integer.toString(i+j);
        return s;
        }

    @GetMapping("getrequest")
    @ResponseBody
    public int getrequest(@RequestParam int i, @RequestParam int j){
        return i+j;
    }

    @GetMapping("getbyname/{name}")
    @ResponseBody
    public List<studententity> getbyname(@PathVariable String name){
        List<studententity> s= student.findBysname(name);
        return s;
    }

    @GetMapping("page")
    public String pagedetails(Model m){
        List<studententity> s=student.findAll();
        m.addAttribute("results", s);
        return "details";

    }

    @PostMapping("/postdata")
    @ResponseBody
    public studententity postdata(studententity st){
        student.save(st);
        return st;
    }









}
