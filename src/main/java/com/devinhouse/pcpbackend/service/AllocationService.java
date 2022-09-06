package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.common.exception.ServiceException;
import com.devinhouse.pcpbackend.dto.AllocationDto;
import com.devinhouse.pcpbackend.dto.ClassUpdateDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import com.devinhouse.pcpbackend.repository.TeacherRepository;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private WeekRepository weekRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClassUpdateDto allocationService(AllocationDto allocationDto) {
        try{
            Optional<ClassEntity> classResponse = classRepository.findById(allocationDto.getIdClass());
            Optional<WeekEntity> weekResponse = weekRepository.findById(allocationDto.getIdWeek());
            if(classResponse.isPresent() && weekResponse.isPresent()){
                allocateTeacher(weekResponse.get(), classResponse.get(), allocationDto);
            }
            return modelMapper.map(classResponse.get(), ClassUpdateDto.class);
        }catch (Exception e){
            throw ServiceException.entityNotFoundException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND));
        }
    }

    public ClassUpdateDto findById(Long id) {
        Optional<ClassEntity> classResponse = classRepository.findById(id);
        if(classResponse.isEmpty()){
            throw ApiException.entityNotFoundException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND));
        }
        return modelMapper.map(classResponse.get(), ClassUpdateDto.class);
    }

    public void allocateTeacher(WeekEntity week, ClassEntity classEntity, AllocationDto allocationDto){
        for(ModuleEntity module : classEntity.getModuleEntityList()){
            List<WeekEntity> weekEntityList = module.getWeekEntityList();
            Optional<TeacherEntity> teacherResponse = teacherRepository.findById(allocationDto.getIdTeacher());
            if(week != null &&
                    teacherResponse.isPresent() &&
                    weekEntityList.contains(week) &&
                    teacherRepository.findById(allocationDto.getIdTeacher()).isPresent()){
                week.setTeacherEntity(teacherResponse.get());
                weekRepository.save(week);
            }
        }
    }

}
