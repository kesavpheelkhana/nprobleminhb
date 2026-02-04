package com.example.demo.repository.impl;

import com.example.demo.entity.Friend;
import com.example.demo.entity.Post;
import com.example.demo.repository.CustomPostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CustomPostRepositoryImpl implements CustomPostRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Post> findByUserId(Integer userid){
        String jpql = "SELECT post FROM Post post WHERE post.user.pk = :userId";
        List<Post> posts = em.createQuery(jpql,Post.class)
                .setParameter("userId",userid)
                .getResultList();
        return posts;
    }
}
