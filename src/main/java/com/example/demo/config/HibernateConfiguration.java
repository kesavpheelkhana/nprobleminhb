package com.example.demo.config;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.type.format.FormatMapper;
import org.hibernate.type.format.jackson.JacksonJsonFormatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.hibernate.autoconfigure.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Configuration
public class HibernateConfiguration implements HibernatePropertiesCustomizer {
    private final ObjectMapper objectMapper;

    @Autowired
    public HibernateConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        // Create a custom JacksonJsonFormatMapper using the Spring-managed ObjectMapper
        FormatMapper customJsonFormatMapper = new JacksonJsonFormatMapper(objectMapper);

        // Add the custom format mapper to the Hibernate properties
        hibernateProperties.put(AvailableSettings.JSON_FORMAT_MAPPER, customJsonFormatMapper);
    }
}
