package com.example.streamapitutorial.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    public AuthenticationManagerBuilder authenticationManagerBuilder;
    SecurityConfig(AuthenticationManagerBuilder authenticationManagerBuilder){
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    //http configure security
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //Desactivation de la session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests().requestMatchers("/login/**","/add-user/**","/without-streams","/with-streams").permitAll();
        http.authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/add-product").hasAuthority("admin");
        http.authorizeHttpRequests().requestMatchers(HttpMethod.GET,"/products").hasAuthority("admin");

        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManagerBuilder));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}