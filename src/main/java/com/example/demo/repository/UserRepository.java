package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


//    @EntityGraph(attributePaths = {"posts","friends"})
//    @Override
//    Optional<User> findById(Long aLong);

    @Query("select u from User u left join fetch u.posts left join fetch u.friends where u.id =:id")
    Optional<User> findById(@Param("id") Long id);
}
