package com.escuela.api.controllers;

import com.escuela.api.db.models.Recruiter;
import com.escuela.api.service.interfaces.RecruiterService;
import com.escuela.api.ui.models.RecruiterWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/recruiter")
public class RecruiterProfileController {

    @Autowired
    RecruiterService recruiterService;

    @PostMapping("/addrecruiterprofile")
    public String addRecruiterDetails(@RequestBody Recruiter recuiter){
        return recruiterService.createRecruiterProfile(recuiter);
    }

    @GetMapping("/verifyrecruiter")
    public String verifyRecruiter(@RequestParam (name = "id") String id,
                                  @RequestParam (name="verify") String verifyCode){

        return  (id+ " - "+verifyCode);
    }

}
