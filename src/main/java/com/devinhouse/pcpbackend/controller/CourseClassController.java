package com.devinhouse.pcpbackend.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.exception.ApiException;
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

	public CourseClassController(ClassService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ClassCreateDto> insert(@RequestBody @Valid ClassCreateDto classDto,
			UriComponentsBuilder uriComponentsBuilder) {
		try {
			ClassEntity classEntity = service.createClassEntity(modelMapper.map(classDto, ClassEntity.class));
			URI uri = uriComponentsBuilder.path("/turmas/{id}").buildAndExpand(classEntity.getId()).toUri();
			return ResponseEntity.created(uri).body(modelMapper.map(classEntity, ClassCreateDto.class));
		} catch (Exception e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClassUpdateDto> update(@RequestBody @Valid ClassUpdateDto classUpdateDto,
			@PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
		try {
			ClassEntity classEntity = service.updateClassEntity(modelMapper.map(classUpdateDto, ClassEntity.class), id);
			URI uri = uriComponentsBuilder.path("/turmas/{id}").buildAndExpand(classEntity.getId()).toUri();
			return ResponseEntity.created(uri).body(modelMapper.map(classEntity, ClassUpdateDto.class));
		} catch (Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

    @GetMapping("/listar")
    public ResponseEntity<List<ClassReadDto>> findAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "100") int limit) {
        List<ClassReadDto> returnValue = new ArrayList<>();
        List<ClassEntity> classesEntity = service.findAll(page, limit);
        returnValue = ClassReadDto.converterClassEntityToDtoList(classesEntity);
        return ResponseEntity.ok().body(returnValue);
    }

	@GetMapping("/listar/{id}")
	public ResponseEntity<ClassUpdateDto> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok().body(service.findById(id));
		} catch (Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, DefaultMessageConstants.CLASS_NOT_FOUND.getMessage());
		}
	}
    
    @PatchMapping("/arquivar")
    public void updateArchived(@RequestBody @Valid ClassArchiveDto archiveUpdateDto) {
    	service.setArchivedClass(archiveUpdateDto);
    }

}