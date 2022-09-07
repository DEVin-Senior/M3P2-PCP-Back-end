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
public class DashboardDto {
    @NotBlank
    private String className;

    @NotBlank
    private String stack;

    @NotBlank
    private String teacherName;

    @NotBlank
    private String matrixLink;

    //@NotBlank
    //private String moduleName;

    @NotBlank
    private String paid;
}
