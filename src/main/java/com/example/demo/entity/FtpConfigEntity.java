package com.example.demo.entity;

import com.example.demo.entity.enumerator.UploadType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@DiscriminatorValue("0")
public class FtpConfigEntity extends AbstractConfigEntity<FtpConfigEntity.Credential>
implements AbstractConfigEntity.ICredential{

    @Builder
    public FtpConfigEntity(int clientId, String name, LocalDateTime expirationDate, FtpConfigEntity.Credential credential) {
        super(clientId, UploadType.FTP, name, expirationDate, credential);
    }

    public record Credential(
            String ip,
            int port,
            String username,
            String password,
            int connectionTimeoutMs,
            int readTimeoutMs
    ) implements ICredential {}
}