package com.devinhouse.pcpbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devinhouse.pcpbackend.dto.TeacherDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.service.ClassService;

@RequestMapping("/turmas")
@RestController
public class CourseClassController {
	
	@Autowired
	private ClassService service;
	
	public CourseClassController (ClassService service) {
		this.service = service;
	}
	
	/*@PostMapping
    public ClassEntity insert(@RequestBody @Valid ClassCreateDto classDto) {
        return service.insert(CourseClassConverter.converterCourseClass(classDto));
    }

	@PutMapping("/{id}")
    public ClassEntity update(@RequestBody @Valid ClassEntity classEntity, @PathVariable Long id) {
        return service.update(id, classEntity);
    }
	
	@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
	
	@GetMapping("/list")
    public List<ClassEntity> findAll() {
        return service.findAll();
    }
	
	@GetMapping("/list/{id}")
	public ClassEntity findById(@PathVariable Long id) {
		return service.findById(id);
	}*/
	
	@PostMapping
    public String insert(@RequestBody @Valid ClassEntity classEntity) {
        return "Class: { " + classEntity.getName() + " - " + classEntity.getInitialDate() + " - " + classEntity.getEndDate() + " - " + classEntity.getMatrixLink() + " }";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody @Valid ClassEntity classEntity, @PathVariable Long id) {
        return "Class: { id:" + classEntity.getId() + " - " + classEntity.getName() + " - " + classEntity.getInitialDate() + " - " + classEntity.getEndDate() + " - "  + classEntity.getMatrixLink() + " }";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "Delete Chamado!";
    }

    @GetMapping("/list")
    public String findAll() {
        return "All Chamado!";
    }

    @GetMapping("/list/{id}")
    public String findById(@PathVariable Long id) {
        return "Get Id Chamado!";
    }
  
}
