package com.devinhouse.pcpbackend.converter;

import com.devinhouse.pcpbackend.dto.TeacherDto;
import com.devinhouse.pcpbackend.model.TeacherEntity;

public class TeacherConverter {

	private TeacherConverter() {}

	public static TeacherEntity converterTeacher(TeacherDto teacherDto) {
		TeacherEntity teacher = new TeacherEntity();

		teacher.setName(teacherDto.getName());
		teacher.setPhone(teacherDto.getPhone());
		teacher.setEmail(teacherDto.getEmail());
		teacher.setSkills(teacherDto.getSkills());
		teacher.setArchived(teacherDto.getArchived());

		return teacher;
	}

}
