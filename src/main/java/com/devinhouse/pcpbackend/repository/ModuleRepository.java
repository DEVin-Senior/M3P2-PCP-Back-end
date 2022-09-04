package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.model.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {
}
