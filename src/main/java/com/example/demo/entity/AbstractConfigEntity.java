package com.example.demo.entity;

import com.example.demo.entity.enumerator.UploadType;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "ab_client_config",schema = "upload")
@DiscriminatorColumn(name = "descrimentor",discriminatorType = DiscriminatorType.INTEGER)
public abstract class AbstractConfigEntity<T extends AbstractConfigEntity.ICredential> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UploadType type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "expire_date", nullable = false)
    private LocalDateTime expirationDate;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "credential", nullable = false, columnDefinition = "json")
    private T credential;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public AbstractConfigEntity(int clientId, UploadType type, String name, LocalDateTime expirationDate, T credential) {
        this.clientId = clientId;
        this.type = type;
        this.name = name;
        this.expirationDate = expirationDate;
        this.credential = credential;
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.CLASS,
            include = JsonTypeInfo.As.PROPERTY,
            property = "@class"
    )
//    @JsonSubTypes({
//            @JsonSubTypes.Type(value = FtpConfigEntity.class)
//    })
    public interface ICredential {}
}
