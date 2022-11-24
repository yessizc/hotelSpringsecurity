package com.hotel.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hotel.demo.models.service.UsuarioServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsuarioServiceImp userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http
            //.csrf().disable()                             
        .authorizeRequests()  
        .anyRequest().permitAll() 
        .and().formLogin().and()  
        .httpBasic()  
        .and()  
        .logout()  
        .logoutUrl("/j_spring_security_logout")  
        .logoutSuccessUrl("/");
        /* .authorizeRequests(authorize -> authorize                                  
		.antMatchers("/login").permitAll()         
		.antMatchers("/*").hasRole("Admin")  
        .antMatchers("/").hasRole("Cliente")                           
		.antMatchers("/*").access("hasRole('Admin') and hasRole('Cliente')")   
		.anyRequest().denyAll()  
                                                      
		);*/
        http.formLogin().defaultSuccessUrl("/", true);
        return http.build();
    }
}
