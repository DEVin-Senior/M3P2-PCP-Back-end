package com.devinhouse.pcpbackend.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.devinhouse.pcpbackend.common.CommonBaseTest;
import com.devinhouse.pcpbackend.dto.TeacherDto;
import com.devinhouse.pcpbackend.enums.SkillEnum;
import com.devinhouse.pcpbackend.model.TeacherEntity;

public class TeacherConverterTest extends CommonBaseTest {

    @InjectMocks
    TeacherConverter teacherConverter;

    private TeacherDto teacherDto;

    @Override
    public void setUp() {
        teacherDto = createTeacherDto();
    }

    @Override
    public void noMoreInteractions() {

    }

    @Test
    public void converterTeacher_shouldReturnTeacherConvertedWhenDtoIsValid(){
        //Act
        TeacherEntity teacherActual = teacherConverter.converterTeacher(teacherDto);

        //Assert
        assertThat(teacherActual.getName()).isEqualTo(teacherDto.getName());
        assertThat(teacherActual.getPhone()).isEqualTo(teacherDto.getPhone());
        assertThat(teacherActual.getEmail()).isEqualTo(teacherDto.getEmail());
        assertThat(teacherActual.getSkills()).size().isEqualTo(teacherDto.getSkills().size());
        assertThat(teacherActual.getArchived()).isEqualTo(teacherDto.getArchived());
    }

    private TeacherDto createTeacherDto(){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setName("Simão Pedro");
        teacherDto.setPhone("(47)98444-6499");
        teacherDto.setEmail("simao.pedro@gmail.com");
        teacherDto.setSkills(List.of(SkillEnum.C_SHARP, SkillEnum.JAVA, SkillEnum.JAVASCRIPT));
        teacherDto.setArchived(Boolean.FALSE);
        return teacherDto;
    }
}
