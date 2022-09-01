package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.common.CommonBaseTest;
import com.devinhouse.pcpbackend.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends CommonBaseTest {

    @Autowired
    UserRepository userRepository;

    @Override
    public void setUp() {
        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        user.setEmail("test@test.com");
        
        userRepository.save(user);
    }

    @Override
    public void noMoreInteractions() {

    }

    @After
    public void after(){
        tearDown(userRepository);
    }

    @Test
    public void testSaveUser() {
        User user2 = new User();
        user2.setId(1);
        user2.setPassword("123456");
        user2.setEmail("test@test.com");

        User response = userRepository.save(user2);

        assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {

        Optional<User> response = userRepository.findByEmail("test@test.com");

        assertTrue(response.isPresent());
        assertEquals("test@test.com", response.get().getEmail());
    }

}
