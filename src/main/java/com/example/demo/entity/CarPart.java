package com.example.demo.entity;

import com.example.demo.pojo.PartDetails;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
public class CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_carpart")
    private int pk;

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private PartDetails partDetails;
}
