package org.zerock.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new ZerockUserService();
	}
	
/*	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		log.warning("==========================configureGlobal==================");
		
		auth.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncoder());
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		log.info("---------------------------");
		log.info("configure");
		log.info("---------------------------");
		
		http.formLogin(); //기본이 디나이 인데 난 로그인 폼으로 들어갈거다
		
		http.rememberMe().tokenValiditySeconds(60*60*24); //자동로그인 시간 설정 하지만 쿠키이기 때문에 나중에 테이블로 넣어서 유지시킬 필요가 있다

	}

}
