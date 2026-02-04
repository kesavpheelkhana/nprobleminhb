package com.example.demo.repository;

import com.example.demo.entity.Post;

import java.util.List;


public interface CustomPostRepository {
    List<Post> findByUserId(Integer userId);
}
