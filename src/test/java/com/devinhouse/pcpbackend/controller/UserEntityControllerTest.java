package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.model.UserEntity;
<<<<<<< HEAD
import com.devinhouse.pcpbackend.service.UserService;
=======
import com.devinhouse.pcpbackend.service.UserEntityService;
>>>>>>> all-backend-08
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

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
public class UserEntityControllerTest {

    private static final Integer ID = 1;
    private static final String PASSWORD = "898989898989";
    private static final String EMAIL = "email@test.com";

    private static final String URL = "/loginRegister";

    @MockBean
<<<<<<< HEAD
    UserService service;
=======
    UserEntityService service;
>>>>>>> all-backend-08

    @Autowired
    MockMvc mvc;

    @Test
    public void testSave() throws Exception {
<<<<<<< HEAD
        BDDMockito.given(service.saveUser(Mockito.any(UserEntity.class))).willReturn(getMockUser());
=======
        BDDMockito.given(service.saveUserEntity(Mockito.any(UserEntity.class))).willReturn(getMockUserEntity());
>>>>>>> all-backend-08

        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(PASSWORD, EMAIL))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
<<<<<<< HEAD
    public void testSaveInvalidUser() throws Exception {
=======
    public void testSaveInvalidUserEntity() throws Exception {
>>>>>>> all-backend-08
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload( "email", PASSWORD))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }


<<<<<<< HEAD
    public UserEntity getMockUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(ID);
        userEntity.setPassword(PASSWORD);
        userEntity.setEmail(EMAIL);

        return userEntity;
    }

    public String getJsonPayload(String password,  String email) throws JsonProcessingException {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(password);
        userEntity.setEmail(email);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userEntity);
=======
    public UserEntity getMockUserEntity() {
        UserEntity user = new UserEntity();
        user.setId(ID);
        user.setPassword(PASSWORD);
        user.setEmail(EMAIL);

        return user;
    }

    public String getJsonPayload(String password,  String email) throws JsonProcessingException {
        UserEntity user = new UserEntity();
        user.setPassword(password);
        user.setEmail(email);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
>>>>>>> all-backend-08
    }

}