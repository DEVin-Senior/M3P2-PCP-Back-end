package com.devinhouse.pcpbackend.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.devinhouse.pcpbackend.common.exception.ServiceException;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    void shouldReturnExceptionWhenClassEntityIsNullTest() {
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
    void shouldReturnClassEntityWhenCreateTest() {
        //Arrange
        when(classRepository.save(classTest)).thenReturn(classTest);

        //Act
        ClassEntity classSave = classService.createClassEntity(classTest);

        //Assert
        assertThat(classSave).isEqualTo(classTest);
    }

    @Test()
    void shouldReturnExceptionWhenClassEntitySaveTest() {
        //Arrange
        when(classRepository.save(classTest)).thenThrow(new RuntimeException("Erro"));

        //Act
        String message = assertThrows(ServiceException.class , ()-> {
            classService.createClassEntity(classTest);
        }).toString();


        //Assert
        assertThat(message).contains("Causa: Erro");

    }

    @Test
    void shouldReturnClassEntityWhenUpdateTest() {
        //Arrange
        when(classRepository.findClassById(classTest.getId())).thenReturn(classTest);

        //Act
        ClassEntity classSave = classService.updateClassEntity(classTest, classTest.getId());

        //Assert
        assertThat(classSave).isEqualTo(classTest);
    }



    @Test
    void  shouldReturnExceptionWhenClassEntityUpdateSaveTest(){
        //Arrange
        when(classRepository.findClassById(classTest.getId())).thenReturn(classTest);
        when(classRepository.save(classTest)).thenThrow(new RuntimeException("Erro"));

        //Act
        String message = assertThrows(ServiceException.class , ()-> {
            classService.updateClassEntity(classTest, classTest.getId());
        }).toString();


        //Assert
        assertThat(message).contains("Causa: Erro");
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