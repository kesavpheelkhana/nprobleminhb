package com.example.demo.config;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.type.format.jackson.JacksonJsonFormatMapper;
import org.springframework.boot.hibernate.autoconfigure.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // Configure mapper as needed
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature(), true);
        return mapper;
    }

   @Bean
    public HibernatePropertiesCustomizer jsonFormatMapper(final ObjectMapper objectMapper) {
        // Add the custom format mapper to the Hibernate properties
       return properties -> properties.put(AvailableSettings.JSON_FORMAT_MAPPER,
               new JacksonJsonFormatMapper(objectMapper));
    }
}
