package com.devinhouse.pcpbackend.service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devinhouse.pcpbackend.common.constants.EventType;
import com.devinhouse.pcpbackend.common.exception.ServiceException;
import com.devinhouse.pcpbackend.dto.ClassArchiveDto;
import com.devinhouse.pcpbackend.dto.ClassUpdateDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClassService {

	private static final String ENTITY = "Turma";
	private ClassRepository classRepository;
	private EventService eventService;
	private ModelMapper modelMaper;

	public List<ClassEntity> findAll(int page, int limit) {
		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<ClassEntity> classPage = classRepository.findAll(pageableRequest);
		List<ClassEntity> classes = classPage.getContent();

		return classes;
	}

	public Optional<ClassEntity> findById(Long id) {
		return classRepository.findById(id);
	}

	@Transactional
	public ClassEntity createClassEntity(ClassEntity classEntity) {
		if (Objects.isNull(classEntity)) {
			throw ServiceException.entityNotFoundException(ENTITY);
		}
		try {
			classRepository.save(classEntity);
			eventService.createEvent(Instant.now(), EventType.CREATE, classEntity.getId());
			return classEntity;
		} catch (Exception e) {
			throw ServiceException.errorPersistDataException(ENTITY, e.getMessage());
		}
	}

	@Transactional
	public ClassEntity updateClassEntity(ClassEntity classEntity, Long id) {
		ClassEntity storedClassEntity = classRepository.findClassById(id);
		if (Objects.isNull(storedClassEntity)) {
			throw ServiceException.entityNotFoundByIdException(ENTITY, id);
		}
		storedClassEntity.setName(classEntity.getName());
		storedClassEntity.setInitialDate(classEntity.getInitialDate());
		storedClassEntity.setEndDate(classEntity.getEndDate());
		storedClassEntity.setMatrixLink(classEntity.getMatrixLink());
		storedClassEntity.setStack(classEntity.getStack());
		storedClassEntity.setModuleEntityList(classEntity.getModuleEntityList());
		try {
			classRepository.save(storedClassEntity);
			eventService.createEvent(Instant.now(), EventType.UPDATE, storedClassEntity.getId());
			return storedClassEntity;
		} catch (Exception e) {
			throw ServiceException.errorPersistDataException(ENTITY, e.getMessage());
		}
	}

	private void archivedClassEvent(Long id, Boolean flag) {
		if (flag) {
			eventService.createEvent(Instant.now(), EventType.ARCHIVE, id);
		} else {
			eventService.createEvent(Instant.now(), EventType.UNARCHIVE, id);
		}
	}

	public ClassUpdateDto setArchivedClass(ClassArchiveDto classArchive, Long id) {
		ClassEntity classEntity = findById(id).get();
		classEntity.setArchive(classArchive.isArchived());
		archivedClassEvent(id, classArchive.isArchived());

		return modelMaper.map(classEntity, ClassUpdateDto.class);
	}
}
