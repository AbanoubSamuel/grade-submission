package com.ltp.gradesubmission.security;

import com.ltp.gradesubmission.security.filter.AuthenticationFilter;
import com.ltp.gradesubmission.security.filter.ExceptionHandlerFilter;
import com.ltp.gradesubmission.security.filter.JWTAuthorizationFilter;
import com.ltp.gradesubmission.security.manager.CustomAuthenticationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import lombok.AllArgsConstructor;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
        http.headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/h2/**")).permitAll()
                .requestMatchers(HttpMethod.POST, SecurityConstants.LOGIN_PATH).permitAll()
                .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

}