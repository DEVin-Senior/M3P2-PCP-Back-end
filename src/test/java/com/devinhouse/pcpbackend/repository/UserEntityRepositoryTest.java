package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.model.UserEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEntityRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setPassword("123456");
        userEntity.setEmail("test@test.com");
        
        userRepository.save(userEntity);
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void testSaveUser() {
        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId(1);
        userEntity2.setPassword("123456");
        userEntity2.setEmail("test@test.com");

        UserEntity response = userRepository.save(userEntity2);

        assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {

        Optional<UserEntity> response = userRepository.findByEmail("test@test.com");

        assertTrue(response.isPresent());
        assertEquals("test@test.com", response.get().getEmail());
    }

}
