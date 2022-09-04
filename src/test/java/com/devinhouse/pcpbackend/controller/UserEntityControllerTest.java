package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.model.UserEntity;
import com.devinhouse.pcpbackend.service.UserEntityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserEntityControllerTest {

    private static final Integer ID = 1;
    private static final String PASSWORD = "898989898989";

    private static final String NAME = "Vincent Smith";
    private static final String EMAIL = "email@test.com";

    private static final String URL = "/loginRegister";

    @MockBean
    UserEntityService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSaveUserEntityController() throws Exception {

        BDDMockito.given(service.saveUserEntity(Mockito.any(UserEntity.class))).willReturn(getMockUserEntity());


        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(NAME,PASSWORD, EMAIL))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void testSaveInvalidUserEntityController() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(NAME, "email", PASSWORD))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
    
    public UserEntity getMockUserEntity() {
        UserEntity user = new UserEntity();
        user.setName(NAME);
        user.setPassword(PASSWORD);
        user.setEmail(EMAIL);

        return user;
    }

    public String getJsonPayload(String name, String password,  String email) throws JsonProcessingException {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
    }
}