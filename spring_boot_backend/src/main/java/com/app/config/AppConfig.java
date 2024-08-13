package com.app.config;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class AppConfig {

//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		System.out.println("inside appconfig");
//		http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		.authorizeHttpRequests(authorize -> authorize
//				.antMatchers("/api/admin/**").hasAnyRole("RESTAURANT_OWNER","ADMIN")
//				.antMatchers("/api/**").authenticated()
//				.anyRequest().permitAll()
//				).addFilterBefore(new JwtTokenValidator(),BasicAuthenticationFilter.class )
//		         .csrf(csrf -> csrf.disable())
//		         .cors(cors -> cors.configurationSource(corsConfigurationSource()));
//		
//		
//		return http.build();
//	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    System.out.println("inside appconfig");
	    http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(authorize -> authorize
	        		.antMatchers("/api/admin/**").hasAnyRole("RESTAURANT_OWNER","ADMIN")
					.antMatchers("/api/**").authenticated()
					.anyRequest().permitAll()
	        ).addFilterBefore(new JwtTokenValidator(),BasicAuthenticationFilter.class )
	        .csrf(csrf -> csrf.disable())
	        .cors(cors -> cors.configurationSource(corsConfigurationSource()));
	    
	    return http.build();
	}

	
	private CorsConfigurationSource corsConfigurationSource() {
		
		return new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				
				System.out.println("inside corsconfig");
				CorsConfiguration cfg= new CorsConfiguration();
				cfg.setAllowedOrigins(Arrays.asList(
						//frontend URLs to be add here
						));
				//all get put methods
				cfg.setAllowedMethods(Collections.singletonList("*"));
				cfg.setAllowCredentials(true);
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				//for jwt token
				cfg.setExposedHeaders(Arrays.asList("Authorization"));
				cfg.setMaxAge(3600L);
				return cfg ;
			}
			
		};
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}











