package com.example.kc.service;

import com.example.kc.repository.UserRepository;
import com.example.kc.security.RegistredUserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class RegisteredUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user2 = userRepository.findUser2ByEmail(email);

        if (user2 == null) {
            throw new UsernameNotFoundException("User with this email does not exist!");
        }

       return new User(
               user2.getEmail(),
               user2.getPassword(),
               user2.getRoles().stream().map(userRole -> new SimpleGrantedAuthority(userRole.getName())).collect(Collectors.toList())
       );
    }
}
