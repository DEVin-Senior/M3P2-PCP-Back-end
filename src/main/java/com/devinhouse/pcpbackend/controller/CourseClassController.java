package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.dto.ClassCreateDto;
import com.devinhouse.pcpbackend.dto.ClassReadDto;
import com.devinhouse.pcpbackend.dto.ClassUpdateDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.service.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/turmas")
@RestController
public class CourseClassController {

    private ClassService service;
    private ModelMapper modelMapper = new ModelMapper();

    public CourseClassController (ClassService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClassCreateDto> insert(@RequestBody @Valid ClassCreateDto classDto, UriComponentsBuilder uriComponentsBuilder) {
        ClassEntity classEntity = service.createClassEntity(modelMapper.map(classDto, ClassEntity.class));
        URI uri = uriComponentsBuilder.path("/turmas/{id}").buildAndExpand(classEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(classEntity, ClassCreateDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassUpdateDto> update(@RequestBody @Valid ClassUpdateDto classUpdateDto, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
        ClassEntity classEntity = service.updateClassEntity(modelMapper.map(classUpdateDto, ClassEntity.class),id);
        URI uri = uriComponentsBuilder.path("/turmas/{id}").buildAndExpand(classEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(classEntity, ClassUpdateDto.class));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "Delete Chamado!";
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClassReadDto>> findAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<ClassReadDto> returnValue = new ArrayList<>();
        List<ClassEntity> classesEntity = service.findAll(page, limit);

        returnValue = ClassReadDto.converterClassEntityToDtoList(classesEntity);

        return ResponseEntity.ok().body(returnValue);
    }

    @GetMapping("/list/{id}")
    public String findById(@PathVariable Long id) {
        return "Get Id Chamado!";
    }
}