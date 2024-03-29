package com.golismarcin.riverslevelmonitor.security;

import com.golismarcin.riverslevelmonitor.security.model.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private String secret;

    SecurityConfig( @Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           AuthenticationManager authenticationManager,
                                           RiverUserDetailsService userDetailsService) throws Exception {
       http.authorizeRequests(authorize -> authorize
               .antMatchers("/admin/**").hasRole(UserRole.ROLE_ADMIN.getRole())
               .antMatchers("/note/**").hasRole(UserRole.ROLE_CUSTOMER.getRole())
               .antMatchers("/userlist/**").hasRole(UserRole.ROLE_CUSTOMER.getRole())
               .anyRequest().permitAll()
       );
       http.csrf().disable();
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.addFilter(new JwtAuthorizationFilter(authenticationManager, userDetailsService, secret));
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
