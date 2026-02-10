package com.example.demo.pojo;

import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotNull;

@EqualsAndHashCode
public class PartDetailsDimensions {

    @NotNull
    private Long width;

    @NotNull
    private Long height;

    @NotNull
    private Long depth;

}