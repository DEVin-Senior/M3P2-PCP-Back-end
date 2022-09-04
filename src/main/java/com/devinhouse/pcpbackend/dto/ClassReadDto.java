package com.devinhouse.pcpbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassReadDto {

    private Long id;
    private String name;
    private LocalDate initialDate;
    private LocalDate endDate;
    private String stack;
}
