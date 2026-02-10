package com.example.demo.pojo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PartDetails {

    @NotNull
    @Size(max = 2)
    private String countryCode;

    @Valid
    private PartDetailsDimensions dimensions;

    private Long weight;

}
