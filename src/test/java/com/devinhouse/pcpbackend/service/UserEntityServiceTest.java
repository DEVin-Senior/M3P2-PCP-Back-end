package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.model.UserEntity;
import com.devinhouse.pcpbackend.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEntityServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService service;

    @Test
    public void testSaveUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@test.com");
        userEntity.setPassword("1234567");
        Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

        UserEntity userEntityResult = service.saveUser(userEntity);

        assertNotNull(userEntityResult);
    }

    @Test
    public void testDeleteUserById() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@test.com");
        userEntity.setPassword("1234567");
        userEntity.setId(1);
        BDDMockito.willDoNothing().given(userRepository).deleteById(1);

        service.deleteById(1);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1);
    }

}