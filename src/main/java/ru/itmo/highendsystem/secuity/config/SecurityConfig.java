package ru.itmo.highendsystem.secuity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itmo.highendsystem.secuity.filter.JwtFilter;

import java.util.Map;

/**
 * Конфиг для безопасности
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final Map<String, String[]> patternMap = Map.of(
            "USER", new String[]{
                    "*/flights/all",
                    "*/recommendation"
            },
            "ADMIN", new String[]{
                    "*/create/employee",
                    "*/create/account",
                    "*/violation/add",
                    "*/violation/ban"
            },
            "EMPLOYEE", new String[]{"*"},
            "MANAGER", new String[]{"*/crew/add"}
    );

    @Autowired
    private JwtFilter jwtFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .requestMatchers(patternMap.get("ADMIN")).hasRole("ADMIN")
                .requestMatchers(patternMap.get("USER")).hasRole("USER")
                .requestMatchers(patternMap.get("EMPLOYEE")).hasRole("EMPLOYEE")
                .requestMatchers(patternMap.get("MANAGER")).hasRole("MANAGER")
                .requestMatchers("/login").permitAll()
                .and()
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
