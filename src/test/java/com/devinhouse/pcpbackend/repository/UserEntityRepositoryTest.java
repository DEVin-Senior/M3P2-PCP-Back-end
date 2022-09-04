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
    UserEntityRepository userEntityRepository;

    @Before
    public void setUp() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("Vincent Smith");
        user.setPassword("123456");
        user.setEmail("test@test.com");
        
        userEntityRepository.save(user);
    }

    @After
    public void tearDown() {

        userEntityRepository.deleteAll();
    }

    @Test
    public void testSaveUserEntityReturningNotNull() {
        UserEntity user2 = new UserEntity();
        user2.setName("Sean Jones");
        user2.setPassword("1234563");
        user2.setEmail("test3@test.com");

        UserEntity response = userEntityRepository.save(user2);

        assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {

        Optional<UserEntity> response = userEntityRepository.findByEmail("test@test.com");

        assertTrue(response.isPresent());
        assertEquals("test@test.com", response.get().getEmail());
    }

}
