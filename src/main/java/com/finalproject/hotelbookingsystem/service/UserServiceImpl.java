package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.UserDto;
import com.finalproject.hotelbookingsystem.entity.Roles;
import com.finalproject.hotelbookingsystem.entity.User;
import com.finalproject.hotelbookingsystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        List<Roles> roles = Arrays.stream(userDto.getRoles()
                        .split(","))
                .map(w->new Roles(0,w)).collect(Collectors.toList());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(roles);
        System.out.println(user);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

}
