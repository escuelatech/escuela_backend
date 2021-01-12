package com.escuela.api.service.implementations;

import com.escuela.api.service.interfaces.FileuploadService;
import com.escuela.api.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileuploadServiceImpl implements FileuploadService {

    @Autowired
    UserService userService;

    @Override
    public void uploadResume(MultipartFile multipartFile, String email) {
        try {
            byte[] resumeBytes = multipartFile.getBytes();
            userService.saveResume(resumeBytes,email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
