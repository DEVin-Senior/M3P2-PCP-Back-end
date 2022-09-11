package com.devinhouse.pcpbackend.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Size;

import com.devinhouse.pcpbackend.model.ModuleEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassCreateDto {

	@Size(max = 60)
	private String name;

	private LocalDate initialDate;

	private LocalDate endDate;

	@Size(max = 60)
	private String stack;

	@Size(max = 100)
	private String matrixLink;

	private boolean archive;

	private List<ModuleEntity> moduleEntityList;
}
