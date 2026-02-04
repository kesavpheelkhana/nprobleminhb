package com.example.demo.dto;

import com.example.demo.entity.Friend;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class UserProfileDTO {
    private User user;
}
