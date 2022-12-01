package com.example.test;

import io.minio.*;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinioTest {
    public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MinioClient minioClient= MinioClient.builder()
                .endpoint("http://175.178.76.164:9000")
                .credentials("LTasKThIDbOX16cA","jEfUn2EGwW9fIW6Dk99eDYYDAZQTS6DT")
                .build();
        boolean found=minioClient.bucketExists(BucketExistsArgs.builder().bucket("test").build());
        System.out.println("exist?"+found);
        ObjectWriteResponse response= minioClient.uploadObject(UploadObjectArgs.builder().bucket("test")
                .object("1.txt")
                .filename("/1.txt")
                .contentType("file/txt")
                .build());
        System.out.println("upload success"+response.toString());
    }
}
