package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.util.Date;

@Entity
@Table(name = "ab_post")
@Setter
@Getter
@JsonIgnoreProperties({"pk","user"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_post")
    private int pk;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name="post_header")
    private String posthead;

    @ManyToOne() // Many comments to one friend
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;
}
