package com.example.demo.controller;

import com.example.demo.dto.CustomerDataPayload;
import com.example.demo.dto.UserProfileDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.enumerator.UploadType;
import com.example.demo.service.UploadDelegateService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
public class GetProfile {

    @Autowired
    UserService userService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    UploadDelegateService uploadDelegateService;

    @GetMapping("/api/user/{id}/profile")
    public ResponseEntity<UserProfileDTO> getProfileDTO(@PathVariable Long id){
        UserProfileDTO profile = userService.getUserProfile(id);
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/api/user/profile/data")
    public void addProfileDTO(){
        User user = User.builder().username("dummyuserd").build();
        userService.saveUser(user);
    }

    @GetMapping("/uploadtransaction")
    public void getProfileDTO(@RequestBody CustomerDataPayload payload){
        File f = null;
        Resource resource = resourceLoader.getResource("classpath:" + payload.getFilename());
        try{
           f = resource.getFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        uploadDelegateService.upload(payload.getClientId(),payload.getId(),f);
    }
}
