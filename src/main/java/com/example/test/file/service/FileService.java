package com.example.test.file.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    boolean upload(MultipartFile file);
}
