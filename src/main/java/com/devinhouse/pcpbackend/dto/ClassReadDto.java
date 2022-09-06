package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.ClassEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassReadDto {

    @NotNull(message = "Id não pode estar em branco")
    private Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate initialDate;

    @NotNull(message = "Data não pode estar em branco")
    private LocalDate endDate;

    @NotBlank(message = "Stack não pode estar em branco")
    private String stack;
    private boolean archive;


    public static List<ClassReadDto> converterClassEntityToDtoList(List<ClassEntity> classesEntity) {
        List<ClassReadDto> returnValue = new ArrayList<>();

        for(ClassEntity classEntity : classesEntity) {
            ClassReadDto classModel = new ClassReadDto();
            BeanUtils.copyProperties(classEntity, classModel);
            returnValue.add(classModel);
        }
        return returnValue;
    }




}
