package com.medvoda.medenychivoda.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration  {



        @Bean
        public UserDetailsManager userDetailsManager(DataSource dataSource){
            JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
            jdbcUserDetailsManager.setUsersByUsernameQuery("select login, password, id from users where login=?");
            jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select login, role,id from roles where login=?");
            return jdbcUserDetailsManager;
        }
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity httpSecurity )throws Exception{
            httpSecurity.authorizeHttpRequests(configurer->configurer
                    .requestMatchers("/main").hasRole("ADMIN").anyRequest().authenticated());
            httpSecurity.formLogin(form->form.defaultSuccessUrl("/main",true));
            httpSecurity.csrf(csrf-> csrf.disable());

            return httpSecurity.build();
        }
}
