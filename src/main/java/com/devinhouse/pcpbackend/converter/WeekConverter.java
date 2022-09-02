package com.devinhouse.pcpbackend.converter;

import com.devinhouse.pcpbackend.dto.WeekDto;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;

public class WeekConverter {

    private WeekConverter(){}

    // criar objeto week com os dados do week dto que veio no request
    public static WeekEntity converterWeek(WeekDto weekDto){
        WeekEntity week = new WeekEntity();
        // cria objeto vazio e seta o id
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(weekDto.getTeacherId());

        week.setContent(weekDto.getContent());
        week.setInitialDate(weekDto.getInitialDate());

        //passa o objeto teacher para o week
        week.setTeacherEntity(teacher);

        return week;

    }

}
