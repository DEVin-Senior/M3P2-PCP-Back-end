package com.devinhouse.pcpbackend.converter;

import com.devinhouse.pcpbackend.dto.ClassCreateDto;
import com.devinhouse.pcpbackend.model.ClassEntity;


public class CourseClassConverter {
	
	private CourseClassConverter() {}
	
	public static ClassEntity converterCourseClass(ClassCreateDto classDto) {
		
		ClassEntity courseClass = new ClassEntity();
		
		courseClass.setName(classDto.getName());
		courseClass.setInitialDate(classDto.getInitialDate());
		courseClass.setEndDate(classDto.getEndDate());
		courseClass.setStack(classDto.getStack());
		courseClass.setMatrixLink(classDto.getMatrixLink());
		courseClass.setArchive(classDto.getArchive());
		courseClass.setModuleEntityList(classDto.getModuleEntityList());
		courseClass.setEventEntityList(classDto.getEventEntityList());
		
		return courseClass;
	}
}
