package com.example.AOPAC.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @RequestMapping("/config")
    public ConfigurationService configcontrol(){
        return configurationService;
    }
}
