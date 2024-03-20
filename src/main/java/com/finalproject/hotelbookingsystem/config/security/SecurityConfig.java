//package com.finalproject.hotelbookingsystem.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(e->e.disable());
//        httpSecurity.cors(e->e.disable());
//        httpSecurity.authorizeHttpRequests(authRequest ->{
//                    authRequest
//                            //.requestMatchers("/","").permitAll()
//                            .requestMatchers(HttpMethod.POST,"/hotel-api/v1/**").hasAnyAuthority("ADMIN")
//                            .requestMatchers(HttpMethod.DELETE,"/hotel-api/v1/**").hasAnyAuthority("ADMIN")
//                        //    .requestMatchers("").hasAnyAuthority("ADMIN","CUSTOMER")
//                            .anyRequest().authenticated();
//                }).sessionManagement(Customizer.withDefaults())
//                .authenticationProvider(daoAuthenticationProvider())
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return httpSecurity.build();
//    }
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return  daoAuthenticationProvider;
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(List<AuthenticationProvider> authenticationProviders) {
//        return new ProviderManager(authenticationProviders);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}