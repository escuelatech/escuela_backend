package com.escuela.api.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping("/fileupload")
    public String fileUpload(@RequestParam("file")MultipartFile multipartFile){
        try {
            byte[] bytes = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("File is uploaded successfully", multipartFile.getOriginalFilename());
    }
}
