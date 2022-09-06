package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import com.devinhouse.pcpbackend.repository.ModuleRepository;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@AllArgsConstructor

@Service
public class ClassService {
    private ClassRepository classRepository;
    private ModuleRepository moduleRepository;
    private WeekRepository weekRepository;
    @Autowired
    private WeekService weekService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private EntityManager entityManager;

    public List<ClassEntity> findAll(int page, int limit) {
        if(page > 0) page = page - 1;

        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<ClassEntity> classPage = classRepository.findAll(pageableRequest);
        List<ClassEntity> classes = classPage.getContent();

        return classes;
    }


    @Transactional
    public ClassEntity createClassEntity(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

/*    private ModuleEntity insertClassIntoModule(ModuleEntity module) {
        return module;8
    }*/

    public void inserirInfo() {
        /* TODO: Pode ser implementado no Teste (fazer algumas alterações)
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

}

