package com.example.demo.repository.impl;

import com.example.demo.entity.Friend;
import com.example.demo.repository.CustomFriendRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomFriendRepositoryImpl implements CustomFriendRepository {

    @PersistenceContext
    private EntityManager em;


    public List<Friend> findByUserId(int userid){
        String jpql = "SELECT friend FROM Friend friend WHERE friend.user.pk = :userId";
        List<Friend> friends = em.createQuery(jpql,Friend.class)
                        .setParameter("userId",userid)
                                .getResultList();
        return friends;
    }

    /**
     * Deprecated
     * @param userid
     * @return
     */
    public List<Friend> findById(int userid){
        String jpql = "SELECT friend FROM Friend friend WHERE friend.user.pk = :userId";
        List<Friend> friends = em.createQuery(jpql,Friend.class)
                .setParameter("userId",userid)
                .getResultList();
        return friends;
    }
}
