package com.example.spring_security_hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectConfig{

//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorize) -> authorize
//                .requestMatchers("/public-data").permitAll()
//                .requestMatchers("/private-data").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//        )
//                .formLogin(login -> login
//                        .defaultSuccessUrl("/")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/"));
//        return http.build();
//
//    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public-data").permitAll()
                        .requestMatchers("/private-data").hasAnyRole("ADMIN")
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/private-data")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/public-data"));
        return http.build();

    }

}
