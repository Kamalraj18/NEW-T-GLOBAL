package com.example.demo.udemy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    
    @Autowired
    Laptop lap;
    public void show(){
        lap.print();
        System.out.println("hello");
    }
}
