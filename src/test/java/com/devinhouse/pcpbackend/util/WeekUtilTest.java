package com.devinhouse.pcpbackend.util;

import com.devinhouse.pcpbackend.model.WeekEntity;

import java.time.LocalDate;

public class WeekUtilTest {

    public static WeekEntity expectedWeek(){
        WeekEntity week = new WeekEntity();
        week.setId(1L);
        week.setContent("Hello World!");
        week.setInitialDate(LocalDate.now());
        week.setPaid(Boolean.FALSE);
        week.setTeacherEntity(TeacherUtilTest.expectedTeacher());
        return week;
    }
    public static WeekEntity expectedSaveWeek(){
        WeekEntity week = new WeekEntity();
        week.setId(1L);
        week.setContent("Hello World!");
        week.setInitialDate(LocalDate.now());
        week.setPaid(Boolean.FALSE);
        week.setTeacherEntity(TeacherUtilTest.expectedTeacher());
        return week;
    }
}
