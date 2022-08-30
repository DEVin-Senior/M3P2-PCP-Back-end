package com.devinhouse.pcpbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        try {
            endpoints.tokenStore(tokenStore())
                    .authenticationManager(authenticationManager);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) {
        try {
            clients.inMemory().withClient("b5ba8562-289a-11ed-a261-0242ac120002")
                    .secret("c7d119e6-7503-4693-8f92-0163f48cac49").scopes("read", "write")
                    .authorizedGrantTypes("password")
                    .accessTokenValiditySeconds(72000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
