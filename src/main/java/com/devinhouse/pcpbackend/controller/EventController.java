package com.devinhouse.pcpbackend.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devinhouse.pcpbackend.model.ClassEntity;

@RequestMapping("/eventos")
@RestController
public class EventController {

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
    
    /*@PostMapping
    public EventEntity insert(@RequestBody @Valid EventEntity eventEntity) {
        return service.insert(eventEntity);
    }
    
	@PutMapping("/{id}")
    public EventEntity update(@RequestBody @Valid EventEntity eventEntity, @PathVariable Long id) {
        return service.update(id, eventEntity);
    }
    
	@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

	@GetMapping("/list")
    public List<EventEntity> findAll() {
        return service.findAll();
    }
	
	@GetMapping("/list/{id}")
	public EventEntity findById(@PathVariable Long id) {
		return service.findById(id);
	}*/
    
}
