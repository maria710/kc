package com.example.kc.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/admin/**"))
                                .hasAnyRole("ADMIN", "USER")
                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/post/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/cart/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/aboutUs/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/gallery/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/img/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/showCart/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/products/**")).permitAll()

                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout( logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
