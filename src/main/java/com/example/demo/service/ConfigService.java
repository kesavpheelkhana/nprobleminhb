package com.example.demo.service;

import com.example.demo.dto.ConfigCreateRequest;
import com.example.demo.dto.ConfigDto;
import com.example.demo.entity.AbstractConfigEntity;
import com.example.demo.entity.FtpConfigEntity;
import com.example.demo.entity.S3ConfigEntity;
import com.example.demo.entity.WebhookConfigEntity;
import com.example.demo.repository.ConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {
    private final ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public void createFtpCredential(int clientId, ConfigCreateRequest<FtpConfigEntity.Credential> request) {
        FtpConfigEntity entity = new FtpConfigEntity(clientId,request.getName(),request.getExpireDate(),request.getCredential());
        configRepository.save(entity);
    }

    public void createS3Credential(int clientId, ConfigCreateRequest<S3ConfigEntity.Credential> request) {
        S3ConfigEntity entity = new S3ConfigEntity(clientId,request.getName(),request.getExpireDate(),request.getCredential());
        configRepository.save(entity);
    }

    public void createWebhookCredential(int clientId, ConfigCreateRequest<WebhookConfigEntity.Credential> request) {
        WebhookConfigEntity entity = new WebhookConfigEntity(clientId,request.getName(),request.getExpireDate(),request.getCredential());
        configRepository.save(entity);
    }

    public List<ConfigDto> getClientConfigs(int clientId) {
        return configRepository.findByClientId(clientId)
                .stream()
                .map(ConfigDto::map)
                .toList();
    }

    public void delete(int clientId, long id) {
        configRepository.deleteByClientIdAndId(clientId,id);
    }

    public AbstractConfigEntity<?> getConfig(int clientId, long id) {
        return configRepository.findByClientIdAndId(clientId, id)
                .orElseThrow(() -> new RuntimeException("Config not found"));
    }

}
