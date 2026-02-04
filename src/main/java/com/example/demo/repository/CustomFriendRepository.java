package com.example.demo.repository;

import com.example.demo.entity.Friend;

import java.util.List;

public interface CustomFriendRepository {
    List<Friend> findByUserId(int userid);
}
