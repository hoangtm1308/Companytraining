package com.example.companytraining.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void SaveImageFile(Long employeeId, MultipartFile file);
}
