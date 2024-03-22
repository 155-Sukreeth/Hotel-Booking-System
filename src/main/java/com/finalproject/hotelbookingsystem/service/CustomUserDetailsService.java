







package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.entity.User;
import com.finalproject.hotelbookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.getUserByUsername(username);
        System.out.println(" Data base User details:"+user);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username");
        }
        List<GrantedAuthority> authorityList=user.getRoles().stream().map(e->new SimpleGrantedAuthority(e.getRoleName())).collect(Collectors.toList());

        org.springframework.security.core.userdetails.User user2 = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorityList);
        System.out.println("User details are mapped: "+user2);

        return user2;
    }
}