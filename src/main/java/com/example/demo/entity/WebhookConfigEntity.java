package com.example.demo.entity;

import com.example.demo.entity.enumerator.UploadType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@DiscriminatorValue("2")
public class WebhookConfigEntity extends AbstractConfigEntity<WebhookConfigEntity.Credential> {
    @Builder
    public WebhookConfigEntity(int clientId, String name, LocalDateTime expirationDate, WebhookConfigEntity.Credential credential){
        super(clientId, UploadType.WEBHOOK, name, expirationDate, credential);
    }
    public record Credential(
            String apiKey,
            String header,
            String url
    ) implements ICredential {}
}
