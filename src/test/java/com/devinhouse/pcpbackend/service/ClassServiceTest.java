package com.devinhouse.pcpbackend.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.devinhouse.pcpbackend.common.exception.ServiceException;
import org.springframework.data.domain.Page;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ClassServiceTest {

    @Mock
    ClassRepository classRepository;

    @Mock
    EventService eventService;

    @InjectMocks
    ClassService classService;

    private ClassEntity classTest = new ClassEntity();

    @BeforeEach
    void setUp() {
        classTest = createClassEntity();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnExceptionWhenClassEntityIsNull() {
        //Arrange
       classTest = null;

        //Act
        String message = assertThrows(ServiceException.class , ()-> {
            classService.createClassEntity(classTest);
        }).toString();

        //Assert
        assertThat(message).contains("Entity 'Turma' not found");
    }

    @Test
    void shouldReturnClassEntityWhenCreate() {
        //Arrange
        when(classRepository.save(classTest)).thenReturn(classTest);

        //Act

        ClassEntity classSave =  classService.createClassEntity(classTest);

        //Assert
        assertThat(classSave).isEqualTo(classTest);
    }

    @Test
    void test0003() {
        //Arrange
        when(classRepository.save(classTest)).thenThrow(new Exception("..."){});

        //Act
        ClassEntity classSave =  classService.createClassEntity(classTest);


        //Assert
        assertThat(classSave).isEqualTo("Erro ao salvar o Turma");

    }

    @Test
    void test0004() {
        //Arrange


        //Act

        //Assert

    }

    @Test
    void test0005() {
        //Arrange

        //Act

        //Assert

    }

    private WeekEntity creatWeekEntity(){

        WeekEntity week = new WeekEntity();
        week.setInitialDate(LocalDate.now());
        week.setContent("contentWeek");

        return week;
    }

    private ModuleEntity createModuleEntity(){

        ModuleEntity module = new ModuleEntity();

        List<WeekEntity> weeks = new ArrayList<>();
        weeks.add(creatWeekEntity());
        module.setName("nomeModulo");
        module.setWeekEntityList(weeks);

        return module;
    }

    private ClassEntity createClassEntity() {

        ClassEntity classEntity = new ClassEntity();
        List<WeekEntity> weeks = new ArrayList<>();
        List<ModuleEntity> modulos = new ArrayList<>();

        weeks.add(creatWeekEntity());
        modulos.add(createModuleEntity());
        classEntity.setId(5L);
        classEntity.setName("nomeClass");
        classEntity.setInitialDate(LocalDate.now());
        classEntity.setEndDate(LocalDate.now());
        classEntity.setMatrixLink("matrixLinkClass");
        classEntity.setStack("stackClass");
        classEntity.setArchive(false);
        classEntity.setModuleEntityList(modulos);

        return  classEntity;

    }
}