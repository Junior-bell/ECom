package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.http.HttpStatus;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF (already stateless API)
            .csrf(csrf -> csrf.disable())
            
            // Ensure stateless session management
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            
            // Handle unauthorized access by returning 401 instead of redirecting
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            )
            
            // Disable HTTP Basic Auth to prevent browser popup
            .httpBasic(httpBasic -> httpBasic.disable())
            
            // Configure authorization rules
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers("/", "/api/products","/api/login").permitAll()
                // Authenticated endpoints
                .requestMatchers("/api/cart/**", "/api/orders/**", "/api/users/**").authenticated()
                // Any other request requires authentication
                .anyRequest().authenticated()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory user for testing (replace with database-backed user later)
        var user = User.withUsername("admin")
                       .password("{noop}password") // No encoding for testing
                       .roles("USER", "ADMIN")
                       .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(false);
            }
        };
    }
}