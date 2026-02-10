package com.example.demo.service;

import com.example.demo.config.IUploadClient;
import com.example.demo.entity.AbstractConfigEntity;
import com.example.demo.entity.S3ConfigEntity;
import com.example.demo.entity.enumerator.UploadType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
public class S3UploadClient implements IUploadClient {


    @Override
    public UploadType getUploadType() {
        return UploadType.S3;
    }

    @Override
    public void upload(AbstractConfigEntity.ICredential credential, File file) {
        S3ConfigEntity.Credential convertedCredential = (S3ConfigEntity.Credential) credential;
        //todo
        log.info("Uploading file '{}' to S3 bucket in region: {} using access key: {}, secret key: {}",
                file.getName(),
                convertedCredential.region(),
                convertedCredential.accessKey(),
                convertedCredential.secretKey());
    }

}
