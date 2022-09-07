package com.devinhouse.pcpbackend.converter;

import com.devinhouse.pcpbackend.dto.WeekDto;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;

public class WeekConverter {

    private WeekConverter(){}

    // criar objeto week com os dados do week dto que veio no request
    public static WeekEntity converterWeek(WeekDto weekDto){
        WeekEntity week = new WeekEntity();

        week.setContent(weekDto.getContent());
        week.setInitialDate(weekDto.getInitialDate());

        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(weekDto.getTeacherId());
        week.setTeacherEntity(teacher);

        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(weekDto.getClassId());
        week.setClassEntity(classEntity);

        //ModuleEntity moduleEntity = new ModuleEntity();
        //moduleEntity.setId(weekDto.getModuleId());
        //week.setModuleEntity(moduleEntity);

        return week;
    }

}
