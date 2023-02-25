package com.example.springsercurity.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        PathRequest.H2ConsoleRequestMatcher h2ConsoleRequestMatcher = PathRequest.toH2Console();
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(h2ConsoleRequestMatcher).permitAll()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/img/**", "/styles/**").permitAll()
                .mvcMatchers("/register", "/confirmation").permitAll()
                .mvcMatchers("/secured", "/change-password").hasAnyRole("USER", "ADMIN")
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                .logoutRequestMatcher(new AntPathRequestMatcher("*/logout/**", HttpMethod.GET.name()))
                .logoutSuccessUrl("/")
        );
        http.csrf(httpSecurityCsrfConfigurer ->
                httpSecurityCsrfConfigurer.ignoringRequestMatchers(h2ConsoleRequestMatcher)
        );
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}






































