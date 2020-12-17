package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VehicleDto {
    @NotNull
    private String typeId;

    @NotNull
    private String officeId;
}
