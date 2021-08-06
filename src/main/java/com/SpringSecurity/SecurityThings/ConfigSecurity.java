package com.SpringSecurity.SecurityThings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SpringSecurity.SecurityThings.service.CustomUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailsService customUserDetails;

	@Override
	public void configure(HttpSecurity web) throws Exception {
		web.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}

//	@Autowired
//	public void configureGlobal(  AuthenticationManagerBuilder auth) throws Exception {
//		
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication().
//		withUser("administrador").
//		password(encoder.encode("123")).
//		roles("ADMIN")
//		.and()
//		.withUser("batman")
//		.password(encoder.encode("123"))
//		.roles("USER");
//		
//	}
	
	public void configure(  AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserDetails).passwordEncoder( new BCryptPasswordEncoder());
	}
	

}
