package com.provavis.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	 
		@Bean
	    public SecurityFilterChain   securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	    			httpSecurity
	                .csrf(csrf -> csrf.disable())
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authorizeHttpRequests(authorize -> authorize	                                                
	                        .requestMatchers(HttpMethod.GET, "/backend").permitAll()	                        
	                        .anyRequest().authenticated());
	    			return httpSecurity.build();
	                
	    }
	
	
}
