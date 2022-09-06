package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.common.constants.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

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
}
