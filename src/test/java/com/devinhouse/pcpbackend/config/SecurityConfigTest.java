package com.devinhouse.pcpbackend.config;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.devinhouse.pcpbackend.common.CommonBaseTest;

public class SecurityConfigTest extends CommonBaseTest {

    @Autowired
    SecurityConfig securityConfig;

    @Override
    public void setUp() {}

    @Override
    public void noMoreInteractions() {}

    @Test
    public void securityConfigAuthenticationManagerNotNullTest(){

        AuthenticationManager manager = securityConfig.authenticationManager();

        Assertions.assertNotNull(manager);
    }

}
