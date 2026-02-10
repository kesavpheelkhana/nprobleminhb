package com.example.demo.service;

import com.example.demo.config.IUploadClient;
import com.example.demo.entity.AbstractConfigEntity;
import com.example.demo.entity.WebhookConfigEntity;
import com.example.demo.entity.enumerator.UploadType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
public class WebhookUploadClient implements IUploadClient {


    @Override
    public UploadType getUploadType() {
        return UploadType.WEBHOOK;
    }

    @Override
    public void upload(AbstractConfigEntity.ICredential credential, File file) {
        WebhookConfigEntity.Credential convertedCredential = (WebhookConfigEntity.Credential) credential;
        //todo
        log.info("Uploading file '{}' to Webhook with URL: {} and API Key: {}:{}",
                file.getName(),
                convertedCredential.url(),
                convertedCredential.header(),
                convertedCredential.apiKey());
    }

}
