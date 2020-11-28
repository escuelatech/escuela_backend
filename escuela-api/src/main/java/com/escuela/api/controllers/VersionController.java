package com.escuela.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/")
public class VersionController {

    @GetMapping
    public String getApiVersion(){
        return "v1.0";
    }

}
