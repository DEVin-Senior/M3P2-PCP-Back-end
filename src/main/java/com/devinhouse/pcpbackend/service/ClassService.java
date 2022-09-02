package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassRepository repository;

    public ClassService(ClassRepository classRepository) {
        this.repository = classRepository;
    }

    public ClassEntity insert(ClassEntity classEntity) {
        return repository.save(classEntity);
    }

    public ClassEntity update(Long id, ClassEntity classEntity) {
        ClassEntity updatedClassEntity = repository.findById(id).get();
        updatedClassEntity.setName(classEntity.getName());
        updatedClassEntity.setInitialDate(classEntity.getInitialDate());
        updatedClassEntity.setEndDate(classEntity.getEndDate());
        updatedClassEntity.setSkills(classEntity.getSkills());
        updatedClassEntity.setMatrixLink(classEntity.getMatrixLink());
        updatedClassEntity.setModules(classEntity.getModules());
        return repository.save(updatedClassEntity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ClassEntity> findAll() {
        return repository.findAll();
    }

    public ClassEntity findById(Long id) {
        return repository.findById(id).get();
    }
}
