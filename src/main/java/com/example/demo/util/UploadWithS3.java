package com.example.demo.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class UploadWithS3 {

    @PostConstruct
    public void init(){
        System.out.println("hi i am initializing");
    }
}
