package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends PagingAndSortingRepository<ClassEntity, Long> {
}
