package com.devinhouse.pcpbackend.controller;

import java.util.List;

import javax.validation.Valid;

import com.devinhouse.pcpbackend.dto.ArchivedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.devinhouse.pcpbackend.converter.TeacherConverter;
import com.devinhouse.pcpbackend.dto.TeacherDto;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.service.TeacherService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@PostMapping
	public TeacherEntity insert(@RequestBody @Valid TeacherDto teacherDto) {
		return service.insert(TeacherConverter.converterTeacher(teacherDto));
	}

	@PutMapping("/{id}")
	public TeacherEntity update(@RequestBody @Valid TeacherDto teacherDto, @PathVariable Long id) {
		return service.update(id, TeacherConverter.converterTeacher(teacherDto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping("/list")
	public List<TeacherEntity> findAll() {
		return service.findAll();
	}

	@GetMapping("/list/{id}")
	public TeacherEntity findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PatchMapping("change-archived")
	public void changeArchived(@RequestBody ArchivedDto dto) {
		service.changeArchived(dto);
	}

}
