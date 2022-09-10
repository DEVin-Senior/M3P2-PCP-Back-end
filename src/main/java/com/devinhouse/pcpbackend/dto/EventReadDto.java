package com.devinhouse.pcpbackend.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devinhouse.pcpbackend.common.constants.EventType;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.EventEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventReadDto {

	@NotBlank(message = "EventType não pode estar em branco")
	private EventType eventType;

	@NotBlank(message = "UserContext não pode estar em branco")
	private String userContext;

	@NotNull(message = "TimeStamp não pode estar em branco")
	private Instant timeStamp;

	@NotNull(message = "O id da turma não pode estar em branco")
	private ClassEntity classEntity;

	public static EventReadDto toDto(EventEntity entity) {
		EventReadDto dto = new EventReadDto();
		dto.setEventType(entity.getEventType());
		dto.setUserContext(entity.getUserContext());
		dto.setTimeStamp(entity.getTimeStamp());

		return dto;
	}

	public static List<EventReadDto> converterEventEntityToDtoList(List<EventEntity> eventsEntity) {
		List<EventReadDto> returnValue = new ArrayList<>();

		for(EventEntity eventEntity : eventsEntity) {
			EventReadDto eventModel = new EventReadDto();
			BeanUtils.copyProperties(eventEntity, eventModel);
			returnValue.add(eventModel);
		}
		return returnValue;
	}
}
