package com.example.kc.service;

import com.example.kc.entity.User2;
import com.example.kc.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RegisteredUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public RegisteredUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User2 user = userRepository.findUser2ByEmail(email);
        if(user != null){
            org.springframework.security.core.userdetails.User authenticatedUser =
                    new org.springframework.security.core.userdetails.User(
                            user.getEmail(),
                            user.getPassword(),
                            user.getRoles().stream()
                                    .map((role) -> new SimpleGrantedAuthority(role.getName()))
                                    .collect(Collectors.toList())
                    );
            return authenticatedUser;
        }else {
            throw new UsernameNotFoundException("Invalid username and password");
        }
    }
}
