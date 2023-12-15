package com.example.rest.demorest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class logginaspect {
    
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(logginaspect.class);

    @After("execution(public * com.example.rest.demorest.rest.details())")
    public void log(){
        LOGGER.info("data fetched");
    }
}
