package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.dto.ClassCreateDto;
import com.devinhouse.pcpbackend.dto.ClassReadDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.service.ClassService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor

@RequestMapping("/turmas")
@RestController
public class CourseClassController {

    private ClassService classService;
    private ModelMapper modelMapper;

    public ClassEntity classCreateDtoForEntity (ClassCreateDto classCreateDto) {
        return modelMapper.map(classCreateDto, ClassEntity.class);
    }

    public ClassReadDto classEntityToClassReadDto(ClassEntity classEntity) {
        return modelMapper.map(classEntity, ClassReadDto.class);
    }


}
