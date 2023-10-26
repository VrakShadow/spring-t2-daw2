package com.cibertec.edu.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		/*.csrf().disable()*/ // esto ira de acorde si activa el RESTFul
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/","/css/**","/js/**","/images/**","/home").permitAll()
			.requestMatchers("/home/profesor/**").hasAnyRole("ADMIN")
			/*.requestMatchers("/api/**").anonymous()*/ // si quiere que la api funcione sin login active esta linea
			.anyRequest().authenticated()
		)
		.formLogin((form) -> form
			/*.successHandler(successhandler)*/
			.loginPage("/login")
			/*.defaultSuccessUrl("/home")*/
			.permitAll()
		)
		.logout((logout) -> logout.permitAll());
		
		/*.exceptionHandling().accessDeniedPage("/error_403");*/
		
		return http.build();
	}

	@Bean
	public static BCryptPasswordEncoder encriptador () {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder passEncoder = encriptador();
		
		UserBuilder userBuilder = User.builder().passwordEncoder(pass -> {
			return passEncoder.encode(pass);
		});
		
		builder.inMemoryAuthentication()
		.withUser(userBuilder.username("admin").password("admin").roles("ADMIN", "USER"))
		.withUser(userBuilder.username("user").password("user").roles("USER"));
	}

}
