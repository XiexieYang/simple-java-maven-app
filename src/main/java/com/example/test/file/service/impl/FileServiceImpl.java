package com.example.test.file.service.impl;

import com.example.test.file.service.FileService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public boolean upload(MultipartFile file) {

        MinioClient minioClient= MinioClient.builder()
                .endpoint("http://175.178.76.164:9000")
                .credentials("LTasKThIDbOX16cA","jEfUn2EGwW9fIW6Dk99eDYYDAZQTS6DT")
                .build();
        try {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket("test")
                    .object(file.getOriginalFilename())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
