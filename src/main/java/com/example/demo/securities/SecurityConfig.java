package com.example.demo.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig{

    private final PersonDetailsServices personDetailsServices;

    public SecurityConfig(PersonDetailsServices personDetailsServices) {
        this.personDetailsServices = personDetailsServices;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http
                .csrf(csrf -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/auth/login", "/auth/registration").permitAll()
//                        .anyRequest().authenticated()
                        .anyRequest().hasAnyRole("USER", "ADMIN")
                )
                .formLogin(form -> {})
                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/process_login")
                        .failureUrl("/auth/login?error")
                        .defaultSuccessUrl("/user/")
                )
                .userDetailsService(personDetailsServices)
//                .headers(headers -> headers.frameOptions().sameOrigin())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )*/
                .build();

//        return http
//                .csrf()
//                .authorizeRequests(auth -> auth
//                        .antMatchers("/h2-console/**").permitAll()
//                        .mvcMatchers("/api/posts/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//
//                .headers(headers -> headers.frameOptions().sameOrigin())
//                .httpBasic(withDefaults())
//                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
