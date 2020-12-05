package com.escuela.api.controllers;

import com.escuela.api.service.interfaces.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/")
public class VersionController {

    @Autowired
    VideoService videoService;

    @GetMapping
    public String getApiVersion(){

        return "v1.0";
    }

}
