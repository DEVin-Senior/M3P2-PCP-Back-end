package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeekCreateDto {

    private String content;
    private LocalDate initialDate;
    private TeacherEntity teacherEntity;
}