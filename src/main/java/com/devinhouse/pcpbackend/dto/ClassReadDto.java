package com.devinhouse.pcpbackend.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.devinhouse.pcpbackend.model.ClassEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	private boolean archive;

	public static List<ClassReadDto> converterClassEntityToDtoList(List<ClassEntity> classesEntity) {
		List<ClassReadDto> returnValue = new ArrayList<>();

		for (ClassEntity classEntity : classesEntity) {
			ClassReadDto classModel = new ClassReadDto();
			BeanUtils.copyProperties(classEntity, classModel);
			returnValue.add(classModel);
		}
		return returnValue;
	}

	public static ClassReadDto converterClassEntityToDto(ClassEntity classEntity) {
		ClassReadDto dto = new ClassReadDto();
		BeanUtils.copyProperties(classEntity, dto);
		return dto;
	}

}
