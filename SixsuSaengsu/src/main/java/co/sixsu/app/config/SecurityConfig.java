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
			.antMatchers("/top","/login", "/", "/work/workKiosk").permitAll()
			.antMatchers("/basic/**","/**/*Info").authenticated()
			.antMatchers("/sales/**", "/prod/cpRec").hasAuthority("ROLE_B")
			.antMatchers("/work/**").hasAuthority("ROLE_C")
			.antMatchers("/material/**", "/prod/spRec", "/prod/spRecInfo").hasAuthority("ROLE_D")
			.antMatchers("/equipment/**").hasAuthority("ROLE_E")
			.antMatchers("/quality/**").hasAuthority("ROLE_F")
			.antMatchers("/**").hasAuthority("ROLE_A") // boot에서는 ROLE_ 생략하고 그냥 ADMIN으로 적는것도 가능
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
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**", "/assets/**");
	}
}
