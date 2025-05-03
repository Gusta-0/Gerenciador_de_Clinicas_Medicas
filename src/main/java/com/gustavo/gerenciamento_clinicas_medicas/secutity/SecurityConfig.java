package com.gustavo.gerenciamento_clinicas_medicas.secutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig { // Mudei o nome da classe também

    @Bean
    public InMemoryUserDetailsManager gerenciadorUsuariosEmMemoria() { // Nome traduzido
        UserDetails usuario = User.withUsername("user")
                .password("{noop}user123")
                .roles("USERS")
                .build();

        UserDetails administrador = User.withUsername("admin")
                .password("{noop}master123")
                .roles("MANAGERS")
                .build();

        return new InMemoryUserDetailsManager(usuario, administrador);
    }

    @Bean
    public SecurityFilterChain cadeiaDeFiltros(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(autorizacao -> autorizacao
                        .requestMatchers("/h2-console/**", "/login", "/esqueci-senha").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formulario -> formulario
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(saida -> saida.permitAll())
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin()) // alternativa atual ao .frameOptions().sameOrigin()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                );

        return http.build();
    }

}