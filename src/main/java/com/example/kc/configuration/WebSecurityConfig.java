package com.example.kc.configuration;


import com.example.kc.security.UserAuthenticationManager;
import com.example.kc.service.RegisteredUserDetailService;
import com.example.kc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    //    private final RegisteredUserDetailService registeredUserDetailService;
    @Autowired
    private UserAuthenticationManager userAuthenticationManager;
    @Autowired
    private UserService userService;

//    @Autowired
//    public WebSecurityConfig(RegisteredUserDetailService registeredUserDetailService) {
//        this.registeredUserDetailService = registeredUserDetailService;
//    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new UserAuthenticationManager(userService, passwordEncoder());
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new RegisteredUserDetailService();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeHttpRequests().requestMatchers("/login", "/register", "/css/**", "/js/**")
//                .permitAll()
//                .and()
//                .formLogin(form -> form.loginPage("/login")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/login?error=true")
//                        .permitAll())
//                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .permitAll());
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests().anyRequest()
                .permitAll()
                .and()
                .formLogin(form -> form.loginPage("/login")
                        .defaultSuccessUrl("/")
                        .successForwardUrl("/")
                        .failureUrl("/login?error=true")
                        .permitAll())
                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll());
        http.authenticationManager(userAuthenticationManager);
        return http.build();
    }

//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(registeredUserDetailService).passwordEncoder(passwordEncoder());
//    }
}
