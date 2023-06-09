package co.sixsu.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import co.sixsu.app.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity // security filter 설정과 같음
public class SecurityConfig{
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
		requests
			.antMatchers("/top","/login", "/", "/work/workKiosk", "/ajax/**").permitAll()
			.antMatchers("/basic/**","/**/*Info", "/prod/*.Ajax", "/sales/*.Ajax", "/work/*.Ajax", "/material/*.Ajax", "/equipment/*.Ajax", "/quality/*.Ajax").authenticated()
			.antMatchers("/sales/**", "/prod/cpRec").hasAnyAuthority("ROLE_B", "ROLE_A")
			.antMatchers("/work/**").hasAnyAuthority("ROLE_C", "ROLE_A")
			.antMatchers("/materials/**", "/prod/spRec", "/prod/spRecInfo").hasAnyAuthority("ROLE_D", "ROLE_A")
			.antMatchers("/equipment/**").hasAnyAuthority("ROLE_E", "ROLE_A")
			.antMatchers("/quality/**").hasAnyAuthority("ROLE_F", "ROLE_A")
			.anyRequest().authenticated())
		//.formLogin().loginPage("/login").usernameParameter("").and()
		.formLogin(login -> login.loginPage("/login")
								.usernameParameter("empId")
								.successHandler(successHandler()))
		.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login")) //.deleteCookies(null) 가능
			.csrf().disable();
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**", "/assets/**", "/fonts/**");
	}
}
