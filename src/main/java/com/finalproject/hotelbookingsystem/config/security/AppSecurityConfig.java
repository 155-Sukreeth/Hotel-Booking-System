package com.finalproject.hotelbookingsystem.config.security;

import com.finalproject.hotelbookingsystem.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private CustomUserDetailsService customeUserDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(e->e.disable());
        httpSecurity.cors(e->e.disable());
        httpSecurity.authorizeHttpRequests(authRequest ->{
                    authRequest
                            .requestMatchers("/user-api/v1/users","/user-api/v1/users/login").permitAll()
                            .requestMatchers("/hotel-api/v1/**").hasAnyAuthority("ADMIN")
                            .requestMatchers("/room-api/v1/**").hasAnyAuthority("ADMIN")
                            .requestMatchers(HttpMethod.GET,"/bookings/**").hasAnyAuthority("ADMIN")
                            .requestMatchers(HttpMethod.PUT,"/bookings/**").hasAnyAuthority("ADMIN","CUSTOMER")
                            .requestMatchers(HttpMethod.POST,"/bookings/**").hasAnyAuthority("ADMIN","CUSTOMER")
                            .requestMatchers(HttpMethod.DELETE,"/bookings/**").hasAnyAuthority("ADMIN","CUSTOMER")
                            .requestMatchers(HttpMethod.DELETE,"/customer/**").hasAnyAuthority("ADMIN","CUSTOMER")
                            .requestMatchers(HttpMethod.GET,"/customer/**").hasAnyAuthority("ADMIN")
                            .requestMatchers(HttpMethod.PUT,"/customer/**").hasAnyAuthority("ADMIN","CUSTOMER")
                            .requestMatchers(HttpMethod.POST,"/customer/**").hasAnyAuthority("ADMIN","CUSTOMER")
                            .anyRequest().authenticated();
                }).sessionManagement(Customizer.withDefaults())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(daoAuthenticationProvider())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        System.out.println("custom service object "+customeUserDetailsService);
        daoAuthenticationProvider.setUserDetailsService(customeUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return  daoAuthenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(List<AuthenticationProvider> authenticationProviders) {
        return new ProviderManager(authenticationProviders);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}