package com.devinhouse.pcpbackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.devinhouse.pcpbackend.common.CommonBaseTest;
import com.devinhouse.pcpbackend.enums.SkillEnum;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.repository.TeacherRepository;

public class TeacherServiceTest extends CommonBaseTest {

    @Mock
    TeacherRepository teacherRepository;

    @InjectMocks
    TeacherService teacherService;

    private TeacherEntity teacherEntity;
    private Long teacherId;

    @Override
    public void setUp() {
        teacherEntity = createTeacherEntity();
        teacherId = teacherEntity.getId();
    }

    @Override
    public void noMoreInteractions() {
        verifyNoMoreInteractions(teacherRepository);
    }

    @Test
    public void insert_shouldReturnTeacherEntityWhenSavedSuccessfully() {
        //Arrange
        when(teacherRepository.save(teacherEntity)).thenReturn(teacherEntity);

        //Act
        TeacherEntity teacherSaved = teacherService.insert(teacherEntity);

        //Assert
        assertThat(teacherSaved).isEqualTo(teacherEntity);

        verify(teacherRepository).save(teacherEntity);
    }

    @Test
    public void update_shouldReturnTeacherUpdatedWhenUpdateSuccessfully() {
        //Arrange
        TeacherEntity teacherToUpdate = createTeacherEntity();
        List<SkillEnum> skillsToUpdate = new ArrayList<>(teacherEntity.getSkills());
        skillsToUpdate.add(SkillEnum.PRIMEFACES);
        teacherToUpdate.setSkills(skillsToUpdate);
        teacherToUpdate.setPhone("(47)98555-4444");

        when(teacherRepository.findById(teacherId)).thenReturn(Optional.of(teacherEntity));
        when(teacherRepository.save(teacherEntity)).thenReturn(teacherEntity);

        //Act
        TeacherEntity teacherUpdated = teacherService.update(teacherId, teacherToUpdate);

        //Assert
        assertThat(teacherUpdated).isEqualTo(teacherToUpdate);
        assertThat(teacherUpdated.getPhone()).isEqualTo(teacherToUpdate.getPhone());
        assertThat(teacherUpdated.getSkills().contains(SkillEnum.PRIMEFACES)).isTrue();

        verify(teacherRepository).findById(teacherId);
        verify(teacherRepository).save(teacherEntity);
    }

    @Test
    public void delete_shouldDeleteWhenFindTeacherById(){
        //Arrange
        doNothing().when(teacherRepository).deleteById(teacherId);

        //Act
        teacherService.delete(teacherId);

        //Assert
        verify(teacherRepository).deleteById(teacherId);
    }

    @Test
    public void findAll_shouldReturnAllTeachersWhenFindAll(){
        //Arrange
        List<TeacherEntity> teachersExpected = List.of(teacherEntity);

        when(teacherRepository.findAll()).thenReturn(teachersExpected);

        //Act
        List<TeacherEntity> teachersActual = teacherService.findAll();

        //Assert
        assertThat(teachersActual).isEqualTo(teachersExpected);
        assertThat(teachersActual).size().isEqualTo(teachersExpected.size());

        verify(teacherRepository).findAll();
    }

    @Test
    public void findById_shouldReturnOneTeacherWhenFindById(){
        //Arrange
        when(teacherRepository.findById(teacherId)).thenReturn(Optional.of(teacherEntity));

        //Act
        TeacherEntity teacherActual = teacherService.findById(teacherId);

        //Assert
        assertThat(teacherActual).isEqualTo(teacherEntity);

        verify(teacherRepository).findById(teacherId);
    }

    private TeacherEntity createTeacherEntity() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
        teacherEntity.setName("Simão Pedro");
        teacherEntity.setPhone("(47)98444-6499");
        teacherEntity.setEmail("simao.pedro@gmail.com");
        teacherEntity.setSkills(List.of(SkillEnum.C_SHARP, SkillEnum.JAVA, SkillEnum.JAVASCRIPT));
        teacherEntity.setArchived(Boolean.FALSE);
        return teacherEntity;
    }
}