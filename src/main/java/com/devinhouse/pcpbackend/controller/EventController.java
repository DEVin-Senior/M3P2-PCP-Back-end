package com.devinhouse.pcpbackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinhouse.pcpbackend.dto.EventReadDto;
import com.devinhouse.pcpbackend.model.EventEntity;
import com.devinhouse.pcpbackend.service.EventService;

@RequestMapping("/historico")
@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<List<EventReadDto>> getEvents(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "5") int limit) {
		List<EventReadDto> returnValue = new ArrayList<>();
		List<EventEntity> eventsEntity = eventService.findAll(page, limit);

		returnValue = EventReadDto.converterEventEntityToDtoList(eventsEntity);

		return ResponseEntity.ok().body(returnValue);
	}

	@GetMapping("/turmas/{id}")
	public ResponseEntity<List<EventReadDto>> getEventByClassId(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "100") int limit, @PathVariable Long id) {
		List<EventReadDto> returnValue = new ArrayList<>();
		List<EventEntity> eventsEntity = eventService.getEventsByClassId(id, page, limit);

		returnValue = EventReadDto.converterEventEntityToDtoList(eventsEntity);

		return ResponseEntity.ok().body(returnValue);
	}
}
