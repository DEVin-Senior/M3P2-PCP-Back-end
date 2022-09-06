package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.dto.ClassCreateDto;
import com.devinhouse.pcpbackend.dto.ClassReadDto;
import com.devinhouse.pcpbackend.dto.ClassUpdateDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.service.ClassService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    public ClassEntity classEntityReadForEditDto(ClassUpdateDto classUpdateDto) {
        return modelMapper.map(classUpdateDto, ClassEntity.class);
    }
    
    public ClassUpdateDto classEntityEditDto(ClassEntity classEntity) {
        return modelMapper.map(classEntity, ClassUpdateDto.class);
    }
    
    @PostMapping
    public void save (@RequestBody ClassCreateDto classCreateDto) {
        var classEntity = classCreateDtoForEntity(classCreateDto);
        classService.save(classEntity);
    }
    
    @GetMapping
    public ResponseEntity<List<ClassEntity>> getAllClasses () {
        return ResponseEntity.ok().body(classService.getAll());
    }
    
    @PutMapping
    public void update(@RequestBody ClassCreateDto createDto, @PathVariable Long id) {
    	
    }


}
