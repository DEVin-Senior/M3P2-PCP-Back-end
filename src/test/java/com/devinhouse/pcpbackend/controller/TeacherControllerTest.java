package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.common.CommonBaseTest;
import com.devinhouse.pcpbackend.enums.SkillEnum;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.repository.TeacherRepository;
import com.devinhouse.pcpbackend.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TeacherControllerTest extends CommonBaseTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    TeacherService service;
    @MockBean
    TeacherRepository repository;

    @Override
    public void setUp() {
    }

    @Override
    public void noMoreInteractions() {
    }

    @Test
    @DisplayName("Testa se foi realizado insert do Teacher com sucesso.")
    public void shouldInsertTeacherTest() throws Exception{
       TeacherEntity teacher = new TeacherEntity();
       teacher.setId(1L);
       teacher.setName("Rodrigo");
       teacher.setPhone("999999999");
       teacher.setEmail("teste@teste.com");
       teacher.setSkills(Collections.singletonList(SkillEnum.PRIMEFACES));
       teacher.setArchived(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(teacher);

        mvc.perform(MockMvcRequestBuilders.post("/teacher")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
                   ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Testa se foi deletado Teacher com sucesso.")
    public void shouldDeleteTeacherTest() throws Exception{
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(1L);
        teacher.setName("Rodrigo");
        teacher.setPhone("999999999");
        teacher.setEmail("teste@teste.com");
        teacher.setSkills(Collections.singletonList(SkillEnum.PRIMEFACES));
        teacher.setArchived(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(teacher);

        mvc.perform(MockMvcRequestBuilders.delete("/teacher/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Testa se foi listado todos Teacher com sucesso.")
    public void shouldListTeacherTest() throws Exception{
        ArrayList<TeacherEntity> teacher = new ArrayList<>();
        TeacherEntity teacher1 = new TeacherEntity();
        teacher1.setId(1L);
        teacher1.setName("Rodrigo");
        teacher1.setPhone("999999999");
        teacher1.setEmail("teste@teste.com");
        teacher1.setSkills(Collections.singletonList(SkillEnum.PRIMEFACES));
        teacher1.setArchived(true);
        teacher.add(teacher1);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(teacher);

        mvc.perform(MockMvcRequestBuilders.get("/teacher/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Testa se foi atualizado Teacher com sucesso.")
    public void shouldUpdateTeacherTest() throws Exception{
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(1L);
        teacher.setName("Rodrigo");
        teacher.setPhone("888888888");
        teacher.setEmail("teste@teste.com");
        teacher.setSkills(Collections.singletonList(SkillEnum.PRIMEFACES));
        teacher.setArchived(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(teacher);

        mvc.perform(MockMvcRequestBuilders.put("/teacher/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("Testa listar Teacher por Id com sucesso.")
    public void shouldListTeacherPerIdTest() throws Exception{
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(1L);
        teacher.setName("Rodrigo");
        teacher.setPhone("999999999");
        teacher.setEmail("teste@teste.com");
        teacher.setSkills(Collections.singletonList(SkillEnum.PRIMEFACES));
        teacher.setArchived(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(teacher);

        mvc.perform(MockMvcRequestBuilders.get("/teacher/list/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
