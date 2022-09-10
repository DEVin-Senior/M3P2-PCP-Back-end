package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.common.exception.ServiceException;
import com.devinhouse.pcpbackend.dto.AllocationDto;
import com.devinhouse.pcpbackend.dto.ClassAllocationItemDto;
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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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

    public List<ClassAllocationItemDto> fillAllocationList(){
        Iterable<ClassEntity> classEntities = classRepository.findAll();
        List<ClassAllocationItemDto> classAllocationItemDtos = new ArrayList<>();
        for(ClassEntity classEntity : classEntities) {
            ClassAllocationItemDto classAllocationItemDto = new ClassAllocationItemDto();
            List<Integer> months = new ArrayList<>();
            List<Long> weekIds = new ArrayList<>();
            classAllocationItemDto.setClassName(classEntity.getName());
            classAllocationItemDto.setIdClass(classEntity.getId());
            List<ModuleEntity> moduleEntityList = classEntity.getModuleEntityList();
            List<LocalDate> initialDateList = new ArrayList<>();
            List<String> teachersNames = new ArrayList<>();
            List<String> monthsNames = new ArrayList<>();
            for(ModuleEntity moduleEntity : moduleEntityList){
                List<WeekEntity> weekEntityList = moduleEntity.getWeekEntityList();
                for(WeekEntity week : weekEntityList){
                    weekIds.add(week.getId());
                    initialDateList.add(week.getInitialDate());

                    if(week.getInitialDate().getDayOfWeek() == DayOfWeek.MONDAY){
                        monthsNames.add(week.getInitialDate().getMonth().toString());
                    }
                    if(week.getTeacherEntity() != null){
                        teachersNames.add(week.getTeacherEntity().getName());
                    }
                }
            }
            Month initialMonth = classEntity.getInitialDate().getMonth();
            int yearInitial = classEntity.getInitialDate().getYear();
            int startMonthInt = initialMonth.getValue();
            Month endMonth = classEntity.getEndDate().getMonth();
            int endMonthInt = endMonth.getValue();
            int yearFinal = classEntity.getInitialDate().getYear();
            if(yearInitial == yearFinal){
                months.add(startMonthInt);
                if (endMonthInt > startMonthInt) {
                    int i = startMonthInt;
                    while (i < endMonthInt) {
                        i++;
                        months.add(i);
                    }
                }
            }
            classAllocationItemDto.setMonthsDropdown(monthsNames);
            classAllocationItemDto.setWeeksTeachersNames(teachersNames);
            classAllocationItemDto.setMonths(months);
            classAllocationItemDto.setWeeks(weekIds);
            classAllocationItemDto.setWeekInitialDates(initialDateList);
            classAllocationItemDtos.add(classAllocationItemDto);
        }
        return classAllocationItemDtos;
    }

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
