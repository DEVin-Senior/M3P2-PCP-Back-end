package com.devinhouse.pcpbackend.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.devinhouse.pcpbackend.dto.ClassArchiveDto;
import com.devinhouse.pcpbackend.dto.ClassCreateDto;
import com.devinhouse.pcpbackend.dto.ClassReadDto;
import com.devinhouse.pcpbackend.dto.ClassUpdateDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.service.ClassService;

@RequestMapping("/turmas")
@RestController
public class CourseClassController {

	@Autowired
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

    @GetMapping("/listar")
    public ResponseEntity<List<ClassReadDto>> findAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<ClassReadDto> returnValue = new ArrayList<>();
        List<ClassEntity> classesEntity = service.findAll(page, limit);

        returnValue = ClassReadDto.converterClassEntityToDtoList(classesEntity);

        return ResponseEntity.ok().body(returnValue);
    }

    @GetMapping("/list/{id}")
    public Optional<ClassEntity> findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PutMapping("/{id}/arquivar")
    public ResponseEntity<ClassUpdateDto> updateArchived(@RequestBody @Valid ClassArchiveDto archiveUpdateDto, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
    	URI uri = uriComponentsBuilder.path("/turmas/{id}/archived").buildAndExpand(id).toUri();
    	return ResponseEntity.created(uri).body(service.setArchivedClass(archiveUpdateDto, id));
    }
}