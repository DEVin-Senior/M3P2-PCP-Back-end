package com.devinhouse.pcpbackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devinhouse.pcpbackend.model.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

	Page<EventEntity> findByClassEntityId(Long id, Pageable page);
}
