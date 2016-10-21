package com.weiss.forum.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Niklas
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static Logger LOGGER = Logger.getLogger(SecurityConfig.class.getName());
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//	http
//	    .authorizeRequests()
//	    .antMatchers("/css/**", "/index").permitAll()
//	    .antMatchers("/user/**").hasRole("USER")
//	    .and()
//	    .formLogin()
//	    .loginPage("/login").failureUrl("/login-error");
//    }
//
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth
	    .inMemoryAuthentication()
	    .withUser("user").password("password").roles("USER");
    }
}
