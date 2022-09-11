package com.devinhouse.pcpbackend.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.devinhouse.pcpbackend.model.ClassEntity;

@Repository
public interface ClassRepository extends PagingAndSortingRepository<ClassEntity, Long> {
	ClassEntity findClassById(Long id);

	List<ClassEntity> findAll();

	boolean existsByName(String className);
}
