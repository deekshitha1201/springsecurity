package com.example.Configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailService userDetailservice;
	protected void configure(AuthenticationManagerBuilder authentication) throws Exception{
		authentication.userDetailsService(userDetailservice);
	}
	@Bean
	public PasswordEncoder passwoee()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
