package com.escuela.api.controllers;


import com.escuela.api.service.interfaces.FileuploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    final
    FileuploadService fileuploadService;

    public FileUploadController(FileuploadService fileuploadService) {
        this.fileuploadService = fileuploadService;
    }

    @PostMapping("/fileupload")
    public String fileUpload(@RequestParam("file")MultipartFile multipartFile){
        try {
            byte[] bytes = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("File is uploaded successfully", multipartFile.getOriginalFilename());
    }


    @PostMapping("/resume")
    public String uploadResume(@RequestParam("file")MultipartFile multipartFile){
        fileuploadService.uploadResume(multipartFile,"user@gmail.com");
        return String.format("File is uploaded successfully", multipartFile.getOriginalFilename());
    }
}
