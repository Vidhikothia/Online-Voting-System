package com.project.OnlineVotingapp.secuirity;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class OnlineVotingsecurity {
	 @Bean
	    public UserDetailsManager userDetailsManager(DataSource dataSource) {

	        return new JdbcUserDetailsManager(dataSource);
	    }
		
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

			
			
			
			
	        http.authorizeHttpRequests(configurer ->
	                configurer
	                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("Admin")
	                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("Admin")
	                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("Admin")
	                        
	                        .requestMatchers(HttpMethod.GET, "/api/candidates").hasRole("Admin")
	                        .requestMatchers(HttpMethod.GET, "/api/candidates/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.POST, "/api/candidates").hasRole("Admin")
	                        .requestMatchers(HttpMethod.PUT, "/api/candidates/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.DELETE, "/api/candidates/**").hasRole("Admin")
	                        
	                        .requestMatchers(HttpMethod.GET, "/api/elections").hasRole("Admin")
	                        .requestMatchers(HttpMethod.GET, "/api/elections/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.POST, "/api/elections").hasRole("Admin")
	                        .requestMatchers(HttpMethod.PUT, "/api/elections/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.DELETE, "/api/elections/**").hasRole("Admin")
	                        
	                        .requestMatchers(HttpMethod.GET, "/api/votes").hasRole("Admin")
	                        .requestMatchers(HttpMethod.GET, "/api/votes/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.POST, "/api/votes").hasRole("Admin")
	                        .requestMatchers(HttpMethod.PUT, "/api/votes/**").hasRole("Admin")
	                        .requestMatchers(HttpMethod.DELETE, "/api/votes/**").hasRole("Admin")
	        );

	        http.httpBasic(Customizer.withDefaults());

	        // disable Cross Site Request Forgery (CSRF)
	        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
	        http.csrf(csrf -> csrf.disable());

	        return http.build();
	    }
}
