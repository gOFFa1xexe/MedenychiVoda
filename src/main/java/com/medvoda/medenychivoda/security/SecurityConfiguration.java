package com.medvoda.medenychivoda.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity ) throws Exception{
        httpSecurity.authorizeHttpRequests(autoruze -> autoruze
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/singin").permitAll());
        return httpSecurity.build();
    }
}
