package com.example.demo.service;

import com.example.demo.config.IUploadClient;
import com.example.demo.entity.AbstractConfigEntity;
import com.example.demo.entity.FtpConfigEntity;
import com.example.demo.entity.enumerator.UploadType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
public class FtpUploadClient implements IUploadClient {


    @Override
    public UploadType getUploadType() {
        return UploadType.FTP;
    }

    @Override
    public void upload(AbstractConfigEntity.ICredential credential, File file) {
        FtpConfigEntity.Credential convertedCredential = (FtpConfigEntity.Credential) credential;
        //todo
        log.info("Uploading file '{}' to FTP server at IP: {} on port: {} with username: {}",
                file.getName(),
                convertedCredential.ip(),
                convertedCredential.port(),
                convertedCredential.username());
    }


}
