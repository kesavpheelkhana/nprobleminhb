package com.example.demo.service;

import com.example.demo.dto.UserProfileDTO;
import com.example.demo.entity.Friend;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

//    @Autowired
//    CommentRepository commentRepository;

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public UserProfileDTO getUserProfile(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found for UserId: "+userId));
        List<Post> posts = postRepository.findByUserId(userId.intValue());
        List<Friend> friends = friendRepository.findByUserId(userId.intValue());
//        List<Comment> comments = commentRepository.findByUserId(userId);
        return UserProfileDTO.builder().user(user).friends(friends).posts(posts).build();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

}
