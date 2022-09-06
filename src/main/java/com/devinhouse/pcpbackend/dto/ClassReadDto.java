package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.ClassEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
