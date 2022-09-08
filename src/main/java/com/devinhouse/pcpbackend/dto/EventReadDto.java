package com.devinhouse.pcpbackend.dto;

import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devinhouse.pcpbackend.common.constants.EventType;
import com.devinhouse.pcpbackend.model.EventEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	public static EventReadDto toDto(EventEntity entity) {
		EventReadDto dto = new EventReadDto();
		dto.setEventType(entity.getEventType());
		dto.setUserContext(entity.getUserContext());
		dto.setTimeStamp(entity.getTimeStamp());

		return dto;
	}
}
