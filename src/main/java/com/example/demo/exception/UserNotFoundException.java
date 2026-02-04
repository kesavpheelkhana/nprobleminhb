package com.example.demo.exception;


import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException{
    private Integer status = HttpStatus.NOT_FOUND.value();

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(HttpStatus status,String msg){
        super(msg);
        this.status = status.value();
    }
}
