package com.eventapp.security;

import com.eventapp.repo.UserRepo;
import com.eventapp.services.UserDetailsServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserRepo userRepo;
    private UserDetailsServiceImplement userDetailsService;

    //konstruktorem...

    @Autowired
    public WebSecurityConfig(UserRepo userRepo, UserDetailsServiceImplement userDetailsService) {
        this.userRepo = userRepo;
        this.userDetailsService = userDetailsService;
    }

    //hash hasła

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(5);
    }

    //do pobierania userów z serwisu

    @Override
    protected void configure(AuthenticationManagerBuilder authManager) throws Exception {
        authManager.userDetailsService(userDetailsService);
    }

    //TODO uprawnienia do zasobów apki - spiąć z endpointami w kontrolerze

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/temp1").hasRole("USER")
                .antMatchers("/api/v1/temp2").hasRole("USER")
                .and()
                .formLogin().permitAll(); //na wejście wyświetli login page
    }
}