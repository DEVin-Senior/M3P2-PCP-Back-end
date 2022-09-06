package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.dto.ClassReadDto;
import com.devinhouse.pcpbackend.dto.ClassUpdateDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import com.devinhouse.pcpbackend.repository.TeacherRepository;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class ClassService {

    private ClassRepository classRepository;

    private WeekRepository weekRepository;

    private TeacherRepository teacherRepository;

    private ModelMapper modelMapper;
    
    @Transactional
    public void save(ClassEntity classEntity) {
    	classRepository.save(classEntity);
    	
    }
    
    public List<ClassEntity> getAll() {
    	return classRepository.findAll();
    }

    public ClassUpdateDto allocatteTeacher(Long idClass, Long idWeek, Long idTeacher) {
        try{
            Optional<ClassEntity> classResponse = classRepository.findById(idClass);
            if(classResponse.isPresent()){
                Optional<WeekEntity> weekResponse = weekRepository.findById(idWeek);
                for(ModuleEntity module : classResponse.get().getModuleEntityList()){
                    List<WeekEntity> weekEntityList = module.getWeekEntityList();
                    if(weekResponse.isPresent() &&
                            weekEntityList.contains(weekResponse.get()) &&
                            teacherRepository.findById(idTeacher).isPresent()){
                        Optional<TeacherEntity> teacherResponse = teacherRepository.findById(idTeacher);
                        weekResponse.get().setTeacherEntity(teacherResponse.get());
                    }
                }
            }
            return modelMapper.map(classResponse.get(), ClassUpdateDto.class);
        }catch (Exception e){
            throw ApiException.entityNotFoundException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND));
        }
    }

    public ClassUpdateDto findById(Long id) {
        Optional<ClassEntity> classResponse = classRepository.findById(id);
        if(classResponse.isEmpty()){
            throw ApiException.entityNotFoundException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND));
        }
        return modelMapper.map(classResponse.get(), ClassUpdateDto.class);
    }
}
