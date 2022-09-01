package com.devinhouse.pcpbackend.config;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityConfigTest {

    @Autowired
    SecurityConfig securityConfig;

    @Test
    public void securityConfigAuthenticationManagerNotNullTest(){

        AuthenticationManager manager = securityConfig.authenticationManager();

        Assertions.assertNotNull(manager);
    }

}
