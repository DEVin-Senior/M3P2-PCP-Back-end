package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class ClassService {

    private ClassRepository classRepository;
    
    @Transactional
    public void save(ClassEntity classEntity) {
    	classRepository.save(classEntity);
    	
    }
    
    public List<ClassEntity> getAll() {
    	return classRepository.findAll();
    }
}
