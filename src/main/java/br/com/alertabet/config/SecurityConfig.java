package br.com.alertabet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar o uso via Swagger/Postman
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permite todas as requisições
            )
            .httpBasic(Customizer.withDefaults()); // Habilita autenticação básica (opcional)

        return http.build();
    }
}
