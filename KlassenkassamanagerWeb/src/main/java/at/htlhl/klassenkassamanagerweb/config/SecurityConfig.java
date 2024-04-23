package at.htlhl.klassenkassamanagerweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll() // Erlaubt Zugriff auf h2-console
                            .requestMatchers(new AntPathRequestMatcher("/klassenkassa-manager/Student/**")).hasAuthority("SCOPE_write") // Benötigt SCOPE_write für /klassenkassa-manager/Student/**
                            .requestMatchers(new AntPathRequestMatcher(HttpMethod.GET.toString(), "/klassenkassa-manager/Student/**")).permitAll() // Erlaubt GET-Zugriff auf /klassenkassa-manager/Student/**
                            .requestMatchers(new AntPathRequestMatcher("/swagger-ui.html")).permitAll() // Erlaubt Zugriff auf Swagger-UI ohne Authentifizierung
                            .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll() // Erlaubt Zugriff auf Swagger-UI-Ressourcen ohne Authentifizierung
                            .anyRequest().authenticated(); // Alle anderen Anfragen erfordern Authentifizierung
                })
                .oauth2Login(withDefaults())
                .formLogin(withDefaults()) // TODO: Ändern zu FRONTEND
                .build();
    }

}
