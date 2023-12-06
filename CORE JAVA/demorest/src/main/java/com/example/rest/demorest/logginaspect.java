package com.example.rest.demorest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class logginaspect {
    
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(logginaspect.class);

    @Before("execution(public * com.example.rest.demorest.rest.details())")
    public void log(){
        System.out.println("data fetched");
    }
}
