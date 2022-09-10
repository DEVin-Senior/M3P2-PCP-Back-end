package com.devinhouse.pcpbackend.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class ClassArchiveDto {

    @NotEmpty
	public String classId;
    public boolean archived;
}
