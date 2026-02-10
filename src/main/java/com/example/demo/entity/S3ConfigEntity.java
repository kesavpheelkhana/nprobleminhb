package com.example.demo.entity;

import com.example.demo.entity.enumerator.UploadType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@DiscriminatorValue("1")
public class S3ConfigEntity extends AbstractConfigEntity<S3ConfigEntity.Credential> {

    @Builder
    public S3ConfigEntity(int clientId, String name, LocalDateTime expirationDate, Credential credential) {
        super(clientId, UploadType.S3, name, expirationDate, credential);
    }

    public record Credential(
            String accessKey,
            String secretKey,
            String region
    ) implements ICredential {}
}
