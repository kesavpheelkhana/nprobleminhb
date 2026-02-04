package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ab_user")
@Getter
@Setter
@Builder
public class User {

    @Id
//    @Basic(optional = false)
    @Column(name = "pk_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    private String username;

    // One User to Many Posts (Bidirectional)
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Friend> friends = new HashSet<>();

    public User(){

    }

    public User(Long pk,String name){
        this.pk = pk;
        this.username = name;
    }




}
