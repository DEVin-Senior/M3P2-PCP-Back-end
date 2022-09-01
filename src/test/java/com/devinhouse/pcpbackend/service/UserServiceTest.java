package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.common.CommonBaseTest;
import com.devinhouse.pcpbackend.model.User;
import com.devinhouse.pcpbackend.repository.UserRepository;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest extends CommonBaseTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService service;

    @Override
    public void setUp() {

    }

    @Override
    public void noMoreInteractions() {
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("1234567");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User userResult = service.saveUser(user);

        assertNotNull(userResult);
        Mockito.verify(userRepository).save(user);
    }

    @Test
    public void testDeleteUserById() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("1234567");
        user.setId(1);
        BDDMockito.willDoNothing().given(userRepository).deleteById(1);

        service.deleteById(1);

        Mockito.verify(userRepository).deleteById(1);
    }
}