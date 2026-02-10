package com.example.demo.dto;

import com.example.demo.entity.AbstractConfigEntity;
import com.example.demo.entity.enumerator.UploadType;
import java.time.LocalDateTime;

public record ConfigDto(
        UploadType type,
        String name,
        LocalDateTime expireDate,
        AbstractConfigEntity.ICredential credential
) {

    public static ConfigDto map(AbstractConfigEntity<?> entity) {
        return new ConfigDto(entity.getType(),entity.getName(),entity.getExpirationDate(),entity.getCredential());
    }
}