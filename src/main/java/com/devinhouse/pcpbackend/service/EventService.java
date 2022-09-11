package com.devinhouse.pcpbackend.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.constants.EventType;
import com.devinhouse.pcpbackend.common.exception.ServiceException;
import com.devinhouse.pcpbackend.model.EventEntity;
import com.devinhouse.pcpbackend.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	public void createEvent(Instant timeStamp, EventType eventType, Long classId) {
		String userContext = getUserContext();

		switch (eventType) {
		case CREATE:
			repository.save(new EventEntity(timeStamp, EventType.CREATE, userContext, classId));
			break;
		case UPDATE:
			repository.save(new EventEntity(timeStamp, EventType.UPDATE, userContext, classId));
			break;
		case DELETE:
			repository.save(new EventEntity(timeStamp, EventType.DELETE, userContext, classId));
			break;
		case ARCHIVE:
			repository.save(new EventEntity(timeStamp, EventType.ARCHIVE, userContext, classId));
			break;
		case UNARCHIVE:
			repository.save(new EventEntity(timeStamp, EventType.UNARCHIVE, userContext, classId));
			break;
		default:
			throw new ServiceException(DefaultMessageConstants.ERROR_PROCESSING_EVENT.getMessage());
		}
	}

	public List<EventEntity> findAll(int page, int limit) {
		if(page > 0) page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<EventEntity> eventPage = repository.findAll(pageableRequest);
		List<EventEntity> events = eventPage.getContent();
		return events;
	}

	public List<EventEntity> getEventsByClassId(Long id, int page, int limit) {

		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<EventEntity> eventPage = repository.findByClassEntityId(id, pageableRequest);
		List<EventEntity> events = eventPage.getContent();
		return events;
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

