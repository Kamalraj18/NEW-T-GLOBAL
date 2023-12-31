package com.example.StudentInformationSystem.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurity{


    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] WHITE_LIST = {"/Login","/registerPage","/showAll","/search","/studentdashboard"};

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers(WHITE_LIST).permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/Login").usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/showAll",true)
                .failureUrl("/Login?error")
                .permitAll().and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/logout?success").and()
                .httpBasic();

        return http.build();
    }







    }

