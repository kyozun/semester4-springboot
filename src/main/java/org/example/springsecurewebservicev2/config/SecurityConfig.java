package org.example.springsecurewebservicev2.config;

import org.example.springsecurewebservicev2.entity.User;
import org.example.springsecurewebservicev2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.
                        requestMatchers("/api/books", "/api/books/*", "/api/publishers","/api/publishers/*", "/api/publications","/api/publications/*").permitAll().
                        requestMatchers("/api/employees","/api/employees/*").hasRole("EMPLOYEE").
                        requestMatchers("/api/admin").hasRole("ADMIN").
                        anyRequest().authenticated()).
                formLogin(loginForm -> loginForm.permitAll().defaultSuccessUrl("/api/home")).
                logout(logout -> logout.deleteCookies("JSESSIONID")).httpBasic(Customizer.withDefaults());
        http.csrf().disable();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).authorities(user.getRoles().stream().map(role -> "ROLE_" + role.getName()).toArray(String[]::new)).build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
