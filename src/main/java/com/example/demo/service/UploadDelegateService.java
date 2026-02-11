package com.example.demo.service;

import com.example.demo.config.IUploadClient;
import com.example.demo.entity.AbstractConfigEntity;
import com.example.demo.entity.enumerator.UploadType;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Set;

@Service
public class UploadDelegateService {

    private final ConfigService configService;
    private final Set<IUploadClient> uploadClients;

    public UploadDelegateService(ConfigService configService, Set<IUploadClient> uploadClients) {
        this.configService = configService;
        this.uploadClients = uploadClients;
    }

    public void upload(int clientId, long id, File file) {
        AbstractConfigEntity<?> config = configService.getConfig(clientId, id);
       System.out.println("config name from db "+config.getName());
        System.out.println("config type from db "+config.getType().name());
        IUploadClient client = getUploadClient(config.getType());
        client.upload(config.getCredential(), file);
    }

    private IUploadClient getUploadClient(UploadType type) {
        return uploadClients.stream()
                .filter(c -> c.getUploadType() == type)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No upload client found for type: " + type));
    }
}
