package com.devinhouse.pcpbackend.config;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableAuthorizationServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserSecurityService userSecurityService;

    @Override
    protected void configure(HttpSecurity http) {

        try {
            http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable()
                    .cors().and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        } catch (Exception e) {
            throw ApiException.badRequestException(DefaultMessageHelper.getMessage(DefaultMessageConstants.SECURITY_CONFIGURATION_ERROR));
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        try {
            authenticationManagerBuilder.userDetailsService(userSecurityService)
                    .passwordEncoder(passwordEncoder());

        } catch (Exception e) {
            throw ApiException.notPermittedException(DefaultMessageHelper.getMessage(DefaultMessageConstants.SECURITY_CONFIGURATION_ERROR));
        }
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        try {
            return super.authenticationManager();
        } catch (Exception e) {
            throw ApiException.badRequestException(DefaultMessageHelper.getMessage(DefaultMessageConstants.SECURITY_CONFIGURATION_ERROR));
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}