package com.devinhouse.pcpbackend.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.devinhouse.pcpbackend.common.constants.EventType;
import com.devinhouse.pcpbackend.common.exception.ServiceException;
import com.devinhouse.pcpbackend.dto.EventReadDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.EventEntity;
import com.devinhouse.pcpbackend.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	public void createEvent(Instant timeStamp, EventType eventType, ClassEntity classEntity) {
		String userContext = getUserContext();

		switch (eventType) {
		case CREATE:
			repository.save(new EventEntity(timeStamp, EventType.CREATE, userContext, classEntity));
			break;
		case UPDATE:
			repository.save(new EventEntity(timeStamp, EventType.UPDATE, userContext, classEntity));
			break;
		case DELETE:
			repository.save(new EventEntity(timeStamp, EventType.DELETE, userContext, classEntity));
			break;
		case ARCHIVE:
			repository.save(new EventEntity(timeStamp, EventType.ARCHIVE, userContext, classEntity));
			break;
		case UNARCHIVE:
			repository.save(new EventEntity(timeStamp, EventType.UNARCHIVE, userContext, classEntity));
		default:
			throw new ServiceException("Erro ao processar evento");
		}
	}
	
	public Page<EventReadDto> findAll(Pageable pageable) {
		Page<EventReadDto> dtoPage = repository.findAll(pageable).map(EventReadDto::toDto);
		return dtoPage;
	}

	private String getUserContext() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		return username;
	}

}
