package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ab_friend")
@Getter
@Setter
@JsonIgnoreProperties({"pk","user"})
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_friend")
    private int pk;

    private String name;


    @ManyToOne() // Many friends to one user
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;
}
