package com.devinhouse.pcpbackend.model;

import com.devinhouse.pcpbackend.common.constants.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "user_context", nullable = false)
    private String userContext;

    @Column(name = "time_stamp", nullable = false)
    private Instant timeStamp;
}
