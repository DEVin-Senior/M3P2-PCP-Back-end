package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.model.User;
import com.devinhouse.pcpbackend.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService service;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("1234567");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User userResult = service.saveUser(user);

        assertNotNull(userResult);
    }

    @Test
    public void testDeleteUserById() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("1234567");
        user.setId(1);
        BDDMockito.willDoNothing().given(userRepository).deleteById(1);

        service.deleteById(1);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1);
    }

}