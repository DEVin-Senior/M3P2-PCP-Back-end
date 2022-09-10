package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.util.WeekUtilTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class WeekControllerTest {

   @InjectMocks
   private WeekController weekController;
   @Autowired
   MockMvc mockMvc;
   @Autowired
   private ObjectMapper objectMapper;

   private final WeekEntity expectedWeek = WeekUtilTest.expectedWeek();

   @Test
   public void weekTestGetAll() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/week/list"))
               .andExpect((status().isOk()));
   }
}