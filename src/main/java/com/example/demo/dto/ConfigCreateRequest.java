package com.example.demo.dto;

import com.example.demo.entity.AbstractConfigEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ConfigCreateRequest<T extends AbstractConfigEntity.ICredential> {
    private String name;
    private LocalDateTime expireDate;
    private T credential;
}