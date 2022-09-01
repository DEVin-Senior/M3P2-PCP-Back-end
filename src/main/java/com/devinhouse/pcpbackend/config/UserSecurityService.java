package com.devinhouse.pcpbackend.config;

import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.model.UserEntity;
import com.devinhouse.pcpbackend.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserEntity user = userEntityRepository.findByEmail(email)
                .orElseThrow(() -> ApiException.entityNotFoundException(email));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
