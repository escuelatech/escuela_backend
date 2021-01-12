package com.escuela.api.service.implementations;

import com.escuela.api.service.interfaces.FileuploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileuploadServiceImpl implements FileuploadService {

    @Override
    public void uploadResume(MultipartFile multipartFile, String email) {
        try {
            byte[] resumeBytes = multipartFile.getBytes();
            //@TODO
            //Find the user from database
            //Set the resume to user object and save the user back to database
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
