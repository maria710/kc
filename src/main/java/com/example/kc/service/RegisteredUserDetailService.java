//package com.example.kc.service;
//
//import com.example.kc.repository.UserRepository;
//import com.example.kc.security.RegistredUserDetails;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Data
//public class RegisteredUserDetailService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        var user2 = userRepository.findUser2ByEmail(email);
//
//        if (user2 == null) {
//            throw new UsernameNotFoundException("User with this email does not exist!");
//        }
//        return new RegistredUserDetails(user2);
//    }
//}
