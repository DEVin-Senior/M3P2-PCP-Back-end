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
<<<<<<< HEAD
    UserRepository userRepository;

    @Before
    public void setUp() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setPassword("123456");
        userEntity.setEmail("test@test.com");
        
        userRepository.save(userEntity);
=======
    UserEntityRepository userEntityRepository;

    @Before
    public void setUp() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setPassword("123456");
        user.setEmail("test@test.com");
        
        userEntityRepository.save(user);
>>>>>>> all-backend-08
    }

    @After
    public void tearDown() {
<<<<<<< HEAD
        userRepository.deleteAll();
    }

    @Test
    public void testSaveUser() {
        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId(1);
        userEntity2.setPassword("123456");
        userEntity2.setEmail("test@test.com");

        UserEntity response = userRepository.save(userEntity2);
=======
        userEntityRepository.deleteAll();
    }

    @Test
    public void testSaveUserEntity() {
        UserEntity user2 = new UserEntity();
        user2.setId(1);
        user2.setPassword("123456");
        user2.setEmail("test@test.com");

        UserEntity response = userEntityRepository.save(user2);
>>>>>>> all-backend-08

        assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {

<<<<<<< HEAD
        Optional<UserEntity> response = userRepository.findByEmail("test@test.com");
=======
        Optional<UserEntity> response = userEntityRepository.findByEmail("test@test.com");
>>>>>>> all-backend-08

        assertTrue(response.isPresent());
        assertEquals("test@test.com", response.get().getEmail());
    }

}
