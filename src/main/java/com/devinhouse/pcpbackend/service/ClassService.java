package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.common.exception.ServiceException;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.EventEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import com.devinhouse.pcpbackend.repository.ModuleRepository;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@AllArgsConstructor

@Service
public class ClassService {

    private static final String ENTITY = "Turma";
    private ClassRepository classRepository;

    public List<ClassEntity> findAll(int page, int limit) {
        if(page > 0) page = page - 1;

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
        try{
            return classRepository.save(classEntity);
        }catch (Exception e){
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
        storedClassEntity.setArchive(classEntity.isArchive());
        storedClassEntity.setStack(classEntity.getStack());
        storedClassEntity.setModuleEntityList(classEntity.getModuleEntityList());
        try{
            return classRepository.save(storedClassEntity);
        }catch (Exception e){
            throw ServiceException.errorPersistDataException(ENTITY, e.getMessage());
        }
    }
}

