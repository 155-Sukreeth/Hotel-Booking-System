package com.finalproject.hotelbookingsystem.controller;

import com.finalproject.hotelbookingsystem.config.security.JwtUtility;
import com.finalproject.hotelbookingsystem.dto.LoginRequest;
import com.finalproject.hotelbookingsystem.dto.UserDto;
import com.finalproject.hotelbookingsystem.service.CustomUserDetailsService;
import com.finalproject.hotelbookingsystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.security.auth.login.CredentialException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
public class UserController {
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @PostMapping(value = "/users")
    public UserDto userCreateDto(@RequestBody UserDto userDto){
        System.out.println("sfgdhdh");
        return  userService.createUser(userDto);
    }
    @PostMapping(value = "/users/login")
    public String login(@RequestBody LoginRequest loginRequest) throws CredentialException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        if(!authentication.isAuthenticated()){
            throw new CredentialException("Invalid Credentials");
        }
        return jwtUtility.generateToken(loginRequest.getUsername());
    }

}