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
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeekCreateDto {

    @NotBlank(message = "Content não pode estar em branco")
    @Size(max = 60)
    private String content;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate initialDate;

    @NotNull(message = "Professor não pode estar em branco")
    private TeacherEntity teacherEntity;
}
