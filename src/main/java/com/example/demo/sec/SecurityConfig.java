package com.example.demo.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.server.authentication.AuthenticationConverterServerWebExchangeMatcher;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bcpe=new BCryptPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("123")).roles("ADMIN","USER");	
		auth.inMemoryAuthentication().withUser("user").password(bcpe.encode("123")).roles("USER");	
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
		}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//http.csrf().disable();
		//http.headers().frameOptions().disable();
		//http.authorizeRequests().anyRequest().permitAll();}
		http.formLogin();
		
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
	http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
	http.exceptionHandling().accessDeniedPage("/403");}
	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	
	
	}

   
