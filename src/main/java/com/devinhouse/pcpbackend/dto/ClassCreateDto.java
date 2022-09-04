package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.EventEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ClassCreateDto {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private LocalDate initialDate;

    @NotBlank
    @NotNull
    private LocalDate endDate;

    @NotBlank
    @NotNull
    private String stack;

    @NotBlank
    @NotNull
    private String matrixLink;

    @NotBlank
    @NotNull
    private boolean archive;

    @NotBlank
    @NotNull
    @OneToMany
    private List<ModuleEntity> moduleEntityList;

    @NotBlank
    @NotNull
    @OneToMany
    private List<EventEntity> eventEntityList;
}
