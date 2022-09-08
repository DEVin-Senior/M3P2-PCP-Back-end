package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.EventEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassCreateDto {

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(max = 60)
    private String name;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate initialDate;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate endDate;

    @NotBlank(message = "Stack não pode estar em branco")
    @Size(max = 60)
    private String stack;

    @NotBlank(message = "Link da Matriz não pode estar em branco")
    @Size(max = 100)
    private String matrixLink;

    private boolean archive;

    private List<ModuleEntity> moduleEntityList;
}
