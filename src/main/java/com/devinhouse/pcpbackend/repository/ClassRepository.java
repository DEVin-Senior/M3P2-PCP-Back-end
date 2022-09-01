package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
