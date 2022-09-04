package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.common.CommonBaseTest;
import com.devinhouse.pcpbackend.model.User;
import com.devinhouse.pcpbackend.repository.UserRepository;
import com.devinhouse.pcpbackend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest extends CommonBaseTest {

    private static final Integer ID = 1;
    private static final String PASSWORD = "898989898989";
    private static final String EMAIL = "email@test.com";

    private static final String URL = "/loginRegister";

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    private User mockUser;

    @Override
    public void setUp() {
        mockUser = getMockUser();
    }

    @Override
    public void noMoreInteractions() {

    }

    @Test
    public void testSave() throws Exception {
        BDDMockito.given(service.saveUser(Mockito.any(User.class))).willReturn(mockUser);

        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(PASSWORD, EMAIL))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void testSaveInvalidUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload( "email", PASSWORD))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    public User getMockUser() {
        User user = new User();
        user.setId(ID);
        user.setPassword(PASSWORD);
        user.setEmail(EMAIL);

        return user;
    }

    public String getJsonPayload(String password,  String email) throws JsonProcessingException {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
    }
}