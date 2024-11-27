package com.org.inti;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
          .username("jagga")
          .password("jagga")
          .roles("USER", "ADMIN")
          .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
          .username("jagga1")
          .password("jagga1")
          .roles("USER", "ADMIN")
          .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeRequests(authorizeRequests ->
            authorizeRequests
              .requestMatchers("/hi").authenticated()
              .requestMatchers("/hello", "/bye").permitAll()
          )
          .formLogin(withDefaults())
          .httpBasic();
        return http.build();
    }
}
