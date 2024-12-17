package com.raicesapi.raicesmx.service;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.File;

@Service
public class S3Service {

    @Value("${aws.accessKeyId}")
    private String awsAccessKeyId;

    @Value("${aws.secretAccessKey}")
    private String awsSecretAccessKey;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Value("${aws.region}")
    private String region;

    private S3Client s3Client;

    @PostConstruct
    public void init() {
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(awsAccessKeyId, awsSecretAccessKey);
        this.s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }

    // Subir imagen a S3
    public String uploadFile(String key, File file) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        // Subir archivo a S3
        s3Client.putObject(putObjectRequest, file.toPath());

        // Obtener la URL pública del archivo
        return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key)).toString();
    }

    // Obtener la URL pública del objeto
    public String getFileUrl(String key) {
        return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key)).toString();
    }
}
