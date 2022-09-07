package com.devinhouse.pcpbackend.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devinhouse.pcpbackend.common.constants.EventType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "class_to_event", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "class_id"))
	private ClassEntity classEntity;

	private boolean archive;

	public EventEntity(Instant timeStamp, EventType eventType, String userContext, ClassEntity classEntity) {
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.userContext = userContext;
		this.classEntity = classEntity;
		this.archive = false;
	}
}
