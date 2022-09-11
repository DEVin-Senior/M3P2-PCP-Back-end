package com.devinhouse.pcpbackend.service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.constants.EventType;
import com.devinhouse.pcpbackend.common.exception.ApiException;
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

	public List<ClassEntity> findAll(int page, int limit) {
		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<ClassEntity> classPage = classRepository.findAll(pageableRequest);
		List<ClassEntity> classes = classPage.getContent();

		return classes;
	}

	public ClassUpdateDto findById(Long id) {
		ClassEntity entity = classRepository.findById(id).get();
		ClassUpdateDto dto = ClassUpdateDto.converterClassEntityToDto(entity);
		return dto;
	}

	@Transactional
	public ClassEntity createClassEntity(ClassEntity classEntity) {
		validateClassIsNull(classEntity);
		validateClassAlreadyExists(classEntity);
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
		validateClassIsNull(storedClassEntity);

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

	public void setArchivedClass(ClassArchiveDto classArchive) {
		validateClassArchiveDtoForUpdate(classArchive);

		classRepository.findById(Long.valueOf(classArchive.classId)).map(course -> {
			archivedClassEvent(course.getId(), !course.isArchive());
			course.setArchive(classArchive.archived);
			return classRepository.save(course);
		}).orElseThrow(() -> ApiException.entityNotFoundException(ENTITY, classArchive.classId));
	}

	private void archivedClassEvent(Long id, Boolean flag) {
		if (flag) {
			eventService.createEvent(Instant.now(), EventType.ARCHIVE, id);
		} else {
			eventService.createEvent(Instant.now(), EventType.UNARCHIVE, id);
		}
	}

	private void validateClassIsNull(ClassEntity classEntity) {
		if (Objects.isNull(classEntity)) {
			throw ServiceException.entityNotFoundException(ENTITY);
		}
	}

	private void validateClassArchiveDtoForUpdate(ClassArchiveDto classArchive) {
		if (classArchive == null || StringUtils.isEmpty(classArchive.classId)
				|| !StringUtils.isNumeric(classArchive.classId)) {
			throw ApiException.missingParameterException("classId");
		}
	}

	private void validateClassAlreadyExists(ClassEntity classEntity) {
		if (classRepository.existsByName(classEntity.getName())) {
			throw new ServiceException(DefaultMessageConstants.CLASS_ALREADY_EXISTS_WITH_GIVEN_NAME.getMessage());
		}
	}

}
