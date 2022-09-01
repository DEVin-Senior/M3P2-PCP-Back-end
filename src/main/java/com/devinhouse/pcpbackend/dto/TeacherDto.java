package com.devinhouse.pcpbackend.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devinhouse.pcpbackend.enums.SkillEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {

	@NotBlank
	private String name;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String email;
	
	@NotNull
	private List<SkillEnum> skills;
	
	@NotNull
    private Boolean archived;
	
}

