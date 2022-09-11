package com.devinhouse.pcpbackend.util;

import com.devinhouse.pcpbackend.enums.SkillEnum;
import com.devinhouse.pcpbackend.model.TeacherEntity;

import java.util.List;

public class TeacherUtilTest {

    public static TeacherEntity expectedTeacher(){
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(1L);
        teacher.setName("Monique");
        teacher.setPhone("48998571103");
        teacher.setEmail("monique@gmail.com");
        teacher.setSkills(List.of(SkillEnum.JAVA));
        teacher.setArchived(Boolean.FALSE);
        return teacher;
    }
}
