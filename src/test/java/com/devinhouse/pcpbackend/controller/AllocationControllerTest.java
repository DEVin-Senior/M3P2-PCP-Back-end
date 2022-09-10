package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.common.CommonBaseTest;
import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import com.devinhouse.pcpbackend.repository.ModuleRepository;
import com.devinhouse.pcpbackend.repository.TeacherRepository;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import com.devinhouse.pcpbackend.service.AllocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AllocationControllerTest extends CommonBaseTest {

    private static final Integer ID = 1;
    private static final String NAME = "Vincent Smith";
    private static final String PHONE = "(11) 29293-7514";
    private static final String EMAIL = "email@test.com";
    private static final boolean ARCHIVE = false;

    private static final String URL = "/allocation";

    @MockBean
    AllocationService allocationService;

    @Autowired
    WeekRepository weekRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    private MockMvc mockMvc;

    @Override
    public void setUp() {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setArchive(false);
        //classEntity.setEventEntityList(null);
        classEntity.setInitialDate(LocalDate.of(30, 8, 20));
        classEntity.setName("Turma Teste");
        classEntity.setStack("Teste");
        classEntity.setEndDate(LocalDate.of(50, 8, 10));
        ModuleEntity module = new ModuleEntity();
        module.setName("Modulo Teste");
        WeekEntity week = new WeekEntity();
        week.setInitialDate(LocalDate.of(20, 8, 10));
        week.setContent("Teste");
        module.setWeekEntityList(List.of(week));
        classEntity.setModuleEntityList(List.of(module));
        classEntity.setMatrixLink("Teste");

    }

    @Override
    public void noMoreInteractions() {

    }

    @Test
    public void testAllocationController() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.put(URL).content(getJsonPayload(NAME,PHONE, EMAIL, ARCHIVE))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    public String getJsonPayload(String name, String phone,  String email, Boolean archive) throws JsonProcessingException {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName(name);
        teacher.setPhone(phone);
        teacher.setEmail(email);
        teacher.setArchived(archive);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(teacher);
    }

    public void tearDown(ClassRepository repository){
        teacherRepository.deleteAll();
        weekRepository.deleteAll();
        moduleRepository.deleteAll();
        classRepository.deleteAll();
        repository.deleteAll();
    }
}