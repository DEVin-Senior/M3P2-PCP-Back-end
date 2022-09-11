package com.devinhouse.pcpbackend.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;

@Getter
public class ClassArchiveDto {

	@NotEmpty
	public String classId;
	public boolean archived;
}
