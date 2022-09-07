package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.TeacherEntity;
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

    @NotNull
    private Long teacherId;

    @NotNull
    private Long classId;

    //@NotNull
    //private Long moduleId;
}
