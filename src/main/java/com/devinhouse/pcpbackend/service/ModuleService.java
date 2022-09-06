package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final ModuleRepository repository;

    public ModuleService(ModuleRepository repository) {
        this.repository = repository;//
    }

    public ModuleEntity insert(ModuleEntity module) {
        return repository.save(module);
    }

    public ModuleEntity update(Long id, ModuleEntity module) {
        ModuleEntity updatedModule = repository.findById(id).get();
        updatedModule.setWeekEntityList(module.getWeekEntityList());
        updatedModule.setName(module.getName());
        return repository.save(updatedModule);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<ModuleEntity> findAll() {
        return repository.findAll();
    }
    public Optional<ModuleEntity> findById(Long moduleId) {
        return repository.findById(moduleId);
    }
}

