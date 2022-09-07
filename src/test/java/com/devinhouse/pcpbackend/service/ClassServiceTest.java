package com.devinhouse.pcpbackend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassServiceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
    }

    @Test
    void createClassEntity() {
        /* TODO: fazer algumas alterações
        WeekEntity week = new WeekEntity();
        week.setInitialDate(LocalDate.now());
        week.setContent("contentWeek1");

        WeekEntity week2 = new WeekEntity();
        week2.setInitialDate(LocalDate.now());
        week2.setContent("contentWeek2");
        entityManager.persist(week);
        entityManager.persist(week2);

        List<WeekEntity> weeks = new ArrayList<>();
        weeks.add(week);
        List<WeekEntity> weeks2 = new ArrayList<>();
        weeks.add(week2);

        ModuleEntity module = new ModuleEntity();
        module.setName("nomeModulo");
        module.setWeekEntityList(weeks);
        ModuleEntity module2 = new ModuleEntity();
        module2.setName("nomeModulo2");
        module2.setWeekEntityList(weeks2);
        entityManager.persist(module);
        entityManager.persist(module2);

        List<ModuleEntity> modulos = new ArrayList<>();
        modulos.add(module);
        modulos.add(module2);

        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(5L);
        classEntity.setName("nomeClass");
        classEntity.setInitialDate(LocalDate.now());
        classEntity.setEndDate(LocalDate.now());
        classEntity.setMatrixLink("matrixLinkClass");
        classEntity.setStack("stackClass");
        classEntity.setModuleEntityList(modulos);
        entityManager.persist(classEntity);

        ClassEntity mock = createClass(classEntity);*/
    }

    @Test
    void updateClassEntity() {
    }
}