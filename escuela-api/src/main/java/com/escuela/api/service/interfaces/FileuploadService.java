package com.escuela.api.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface FileuploadService {

    void uploadResume(MultipartFile multipartFile,String email);
}
