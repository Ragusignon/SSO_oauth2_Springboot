package com.oauth2.Oauth2Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Inside the Http security");
		http
        .authorizeRequests()
            .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
            .anyRequest().authenticated();
//            .and()
//        .formLogin()
//            .loginPage("/")
//            .permitAll()
//            .and()
//        .logout()
//            .permitAll();
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("inside the username and password");
		auth
			.inMemoryAuthentication()
				.withUser("ragu").password("riya").roles("USER");
	}
}
