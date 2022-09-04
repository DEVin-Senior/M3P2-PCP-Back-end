package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.model.UserEntity;
import com.devinhouse.pcpbackend.repository.UserEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEntityServiceTest {

    @Mock
    UserEntityRepository userEntityRepository;

    @InjectMocks
    UserEntityService service;

    @Test
    public void testSaveUserEntity() {
        UserEntity user = new UserEntity();
        user.setName("Grover Palmer");
        user.setEmail("teste@test.com");
        user.setPassword("1234567");
        Mockito.when(userEntityRepository.save(user)).thenReturn(user);

        UserEntity userResult = service.saveUserEntity(user);

        assertNotNull(userResult);
    }

    @Test
    public void testDeleteUserEntityById() {
        UserEntity user = new UserEntity();
        user.setName("Sean Jones");
        user.setEmail("test@test.com");
        user.setPassword("1234567");
        user.setId(1);
        BDDMockito.willDoNothing().given(userEntityRepository).deleteById(1);

        service.deleteById(1);

        Mockito.verify(userEntityRepository, Mockito.times(1)).deleteById(1);
    }

}