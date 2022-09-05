package com.devinhouse.pcpbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassReadDto {

    @NotNull(message = "Id não pode estar em branco")
    private Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate initialDate;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate endDate;

    @NotBlank(message = "Stack não pode estar em branco")
    private String stack;

    private boolean archive;
}
