package com.w3villa.taskmanagement2.security;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {
  @Autowired
  private UserDetailsService userDetailsService;
  @Autowired
  public Config(CustomUserDetailsService userDetailsService) {
	  this.userDetailsService = userDetailsService;
  }
  @Bean
  public UserDetailsService getUserDetailsService() {
      return new CustomUserDetailsService();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
      daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
      daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
      return daoAuthenticationProvider;
  }
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(authorize -> authorize
                      .requestMatchers("/tasks/**").authenticated()
                      .requestMatchers("/signin").permitAll()
                      .requestMatchers("/signup").permitAll()
                      .anyRequest().authenticated()
              )
              .formLogin(form -> form
                      .loginPage("/signin")
                      .loginProcessingUrl("/login")
              ).logout(logout -> logout.logoutSuccessUrl("/signin"));

      return http.build();

  }
}
