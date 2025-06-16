package br.com.alertabet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuração de segurança da aplicação.
 * <p>
 * Define o comportamento das requisições HTTP, como desabilitação de CSRF
 * e autorização de todas as requisições.
 * </p>
 */
@Configuration
public class SecurityConfig {

     /**
     * Define o filtro de segurança da aplicação.
     *
     * @param http objeto {@link HttpSecurity} usado para configurar as regras de segurança.
     * @return uma instância de {@link SecurityFilterChain} com as configurações aplicadas.
     * @throws Exception em caso de falha na construção do filtro.
     */
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );
        return http.build();
    }
}