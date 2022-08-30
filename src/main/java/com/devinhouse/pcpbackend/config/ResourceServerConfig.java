package com.devinhouse.pcpbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) {
        try {
            http.authorizeRequests().antMatchers("/deleteTeacher").hasRole("ADMIN")
                    .antMatchers("/deleteClass").hasRole("ADMIN")
                    .antMatchers("/user").permitAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
