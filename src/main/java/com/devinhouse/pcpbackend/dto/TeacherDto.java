package com.devinhouse.pcpbackend.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.devinhouse.pcpbackend.enums.SkillEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {

	@NotBlank
	private String name;
	
	@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Telefone informado inválido")
	private String phone;
	
	@Email(message = "E-mail informado inválido")
	private String email;
	
	@NotEmpty
	private List<SkillEnum> skills;
	
	@NotNull
    private Boolean archived;

}

