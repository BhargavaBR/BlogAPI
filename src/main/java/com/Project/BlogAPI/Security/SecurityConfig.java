package com.Project.BlogAPI.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/articles").permitAll()
                .requestMatchers(HttpMethod.POST,"users/singup","users/login").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll();
        return http.build();
    }

}
