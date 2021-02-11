package com.escuela.api.controllers;

import com.escuela.api.db.models.CourseTraining;
import com.escuela.api.service.interfaces.CourseTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/training")
public class CourseTrainingController {
    @Autowired
    CourseTrainingService trainingService;

    @PostMapping("/addtrainee")
    public String addTraineeDetails(@RequestBody CourseTraining trainee){
        return trainingService.createUserTraineeProfile(trainee);
    }

    @GetMapping("/verifytrainee")
    public String verifyTrainee(@RequestParam (name = "id") String id,
                                @RequestParam (name = "verify") String verifyCode){
        return (id+ " - "+verifyCode);
    }

    @GetMapping("/fetchalltrainees")
    public List<CourseTraining> fetchAllTrainees() {
        return trainingService.getAllUserTrainees();
    }
}
