package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.dto.ClassReadDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinhouse.pcpbackend.dto.EventReadDto;
import com.devinhouse.pcpbackend.service.EventService;

import java.util.ArrayList;
import java.util.List;

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

}
