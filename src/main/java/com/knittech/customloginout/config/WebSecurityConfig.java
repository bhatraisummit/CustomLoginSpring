/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.customloginout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author Sumit
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Bean
    public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("ADMIN").build());
            return manager;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
                        .formLogin()
                            .loginPage("/signin").permitAll()
                            .loginProcessingUrl("/signin")
                            .failureUrl("/signin?error")                           
                            .defaultSuccessUrl("/", true)
                        .and()
                        .logout()
                            .logoutUrl("/signout")
                            .invalidateHttpSession(true)
                            .clearAuthentication(true)
                            .deleteCookies("JSESSIONID")
                            .logoutSuccessUrl("/signin?signout").permitAll();
    }
    
}
