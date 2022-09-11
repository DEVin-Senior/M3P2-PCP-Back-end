package com.devinhouse.pcpbackend.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassUpdateDto {

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(max = 60)
    private String name;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate initialDate;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate endDate;

    @NotBlank(message = "Stack não pode estar em branco")
    @Size(max = 60)
    private String stack;

    @NotBlank(message = "Link da Matriz não pode estar em branco")
    @Size(max = 100)
    private String matrixLink;

    private List<ModuleEntity> moduleEntityList;
    

	public static ClassUpdateDto converterClassEntityToDto(ClassEntity classEntity) {
		ClassUpdateDto dto = new ClassUpdateDto();
		BeanUtils.copyProperties(classEntity, dto);
		return dto;
	}

}
