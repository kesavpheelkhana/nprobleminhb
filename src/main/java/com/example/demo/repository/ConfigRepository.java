package com.example.demo.repository;

import com.example.demo.entity.AbstractConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConfigRepository extends JpaRepository<AbstractConfigEntity<?>, Long> {
    Optional<AbstractConfigEntity<?>> findByClientIdAndId(int clientId, long id);
    List<AbstractConfigEntity<?>> findByClientId(int clientId);
    void deleteByClientIdAndId(int clientId, long id);
}