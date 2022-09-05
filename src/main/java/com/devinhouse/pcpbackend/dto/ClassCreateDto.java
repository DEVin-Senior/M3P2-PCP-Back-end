package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.EventEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassCreateDto {

    private String name;
    private LocalDate initialDate;
    private LocalDate endDate;
    private String stack;
    private String matrixLink;
    private Boolean archive;
    private List<ModuleEntity> moduleEntityList;
    private List<EventEntity> eventEntityList;
}
