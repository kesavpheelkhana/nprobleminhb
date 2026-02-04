package com.example.demo.controller;

import com.example.demo.dto.UserProfileDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProfile {

    @Autowired
    UserService userService;

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
}
