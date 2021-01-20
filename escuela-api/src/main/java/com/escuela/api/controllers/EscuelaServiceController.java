package com.escuela.api.controllers;

import com.escuela.api.db.models.EscuelaServiceContent;
import com.escuela.api.jpa.repositories.EscuelaServiceContentRepository;
import com.escuela.api.service.interfaces.EscuelaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service")
public class EscuelaServiceController {

    @Autowired
    EscuelaContentService escuelaContentService;

    @Autowired
    EscuelaServiceContentRepository contentRepository;

    @GetMapping("/getallcontent")
    public List<EscuelaServiceContent> getAllService(){
        return escuelaContentService.getAllService();
    }

    @GetMapping("/getcontent/{id}")
    public List<EscuelaServiceContent> getContentById(@PathVariable Integer id){
        return escuelaContentService.findContentById(id);
    }
}
