package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Setter
@Getter
public class CustomerDataPayload {
    int clientId;
    long id;
    String filename;
}
