package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.TeacherEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class WeekCreateDto {

    @NotBlank
    @NotNull
    private String content;

    @NotBlank
    @NotNull
    private LocalDate initialDate;

    @NotBlank
    @OneToOne
    private TeacherEntity teacherEntity;
}
