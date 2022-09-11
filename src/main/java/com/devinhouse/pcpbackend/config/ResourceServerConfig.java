package com.devinhouse.pcpbackend.config;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.exception.ApiException;
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
            http.csrf().disable().cors().and().authorizeRequests().antMatchers("/teacher/*", "/class/*", "/week/*", "/turmas/*", "/historico/*", "/allocation/*").authenticated()
                    .antMatchers("/loginRegister").permitAll();
        } catch (Exception e) {
            throw ApiException.badRequestException(DefaultMessageHelper.getMessage(DefaultMessageConstants.SECURITY_CONFIGURATION_ERROR));
        }
    }

}
