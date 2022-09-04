package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeekReadDto {

    private Long id;
    private String content;
    private LocalDate initialDate;
    private TeacherEntity teacherEntity;
}
