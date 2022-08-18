package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurity {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/").authenticated()
        .antMatchers(HttpMethod.GET,"/").authenticated()
        .antMatchers(HttpMethod.POST,"/").authenticated()
        .antMatchers(HttpMethod.PUT, "/").authenticated()
        .antMatchers(HttpMethod.DELETE,"/**").hasRole("admin")
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().httpBasic(withDefaults());
        return http.build();
    }
	
}
