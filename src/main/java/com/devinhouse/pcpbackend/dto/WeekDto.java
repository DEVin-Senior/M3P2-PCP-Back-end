package com.devinhouse.pcpbackend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class WeekDto {

    @NotBlank
    private String content;

    @NotNull
    private LocalDate initialDate;

    @NotBlank
    private Boolean paid;

    @NotNull
    private Long teacherId;
}
