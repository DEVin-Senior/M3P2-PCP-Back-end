package com.devinhouse.pcpbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devinhouse.pcpbackend.dto.EventReadDto;
import com.devinhouse.pcpbackend.service.EventService;

@RequestMapping("/historico")
@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<Page<EventReadDto>> getEvents(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.findAll(pageable));
	}

}
