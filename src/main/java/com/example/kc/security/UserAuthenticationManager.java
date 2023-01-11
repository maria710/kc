package com.example.kc.security;

import com.example.kc.entity.User2;
import com.example.kc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UserAuthenticationManager implements AuthenticationManager {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User2 user = userService.findByUsername(authentication.getName());
        if (user != null) {
            if (passwordEncoder.matches((CharSequence) authentication.getCredentials(), user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            } else {
                throw new BadCredentialsException("Invalid password");
            }
        } else {
            throw new BadCredentialsException("Invalid username");
        }

    }
}
