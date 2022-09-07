package com.devinhouse.pcpbackend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ArchivedDto {

    @NotEmpty
    public String teacherId;

    public boolean archived;
}
