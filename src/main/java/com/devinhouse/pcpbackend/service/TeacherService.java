package com.devinhouse.pcpbackend.service;

import java.util.List;
import java.util.Objects;

import com.devinhouse.pcpbackend.common.exception.ServiceException;
import org.springframework.stereotype.Service;

import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.repository.TeacherRepository;

@Service
public class TeacherService {

    private static final String ENTITY = "Docente";

    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public TeacherEntity insert(TeacherEntity teacher) {
        if (Objects.isNull(teacher)) {
            throw ServiceException.entityNotFoundException(ENTITY);
        }

        try{
            return repository.save(teacher);
        }catch (Exception e){
            throw ServiceException.errorPersistDataException(ENTITY, e.getMessage());
        }
    }

    public TeacherEntity update(Long id, TeacherEntity teacher) {
        if (Objects.isNull(teacher)) {
            throw ServiceException.entityNotFoundException(ENTITY);
        }

        TeacherEntity updatedTeacher = repository.findById(id)
                                                 .orElseThrow(() -> ServiceException.entityNotFoundByIdException(ENTITY, id));

        updatedTeacher.setName(teacher.getName());
        updatedTeacher.setPhone(teacher.getPhone());
        updatedTeacher.setEmail(teacher.getEmail());
        updatedTeacher.setSkills(teacher.getSkills());
        updatedTeacher.setArchived(teacher.getArchived());

        try {
            return repository.save(updatedTeacher);
        } catch (Exception e) {
            throw ServiceException.errorUpdateDataByIdException(ENTITY, id, e.getMessage());
        }
    }

    public void delete(Long id) {
        if (Objects.isNull(id)) {
            throw ServiceException.fieldIsRequiredException("ID");
        }

        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw ServiceException.errorDeleteDataByIdException(ENTITY, id, e.getMessage());
        }
    }

    public List<TeacherEntity> findAll() {
        return repository.findAll();
    }

    public TeacherEntity findById(Long teacherId) {
        if (Objects.isNull(teacherId)) {
            throw ServiceException.fieldIsRequiredException("ID");
        }
        return repository.findById(teacherId)
                         .orElseThrow(() -> ServiceException.entityNotFoundByIdException(ENTITY, teacherId));
    }

}
