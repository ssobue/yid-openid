package dev.sobue.auth.yid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // @formatter:off
    return http
        .authorizeHttpRequests(
            a ->
                a.requestMatchers("/", "/top", "/error", "/webjars/**", "/actuator/health")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .oauth2Login(
            o ->
                o.defaultSuccessUrl("/view"))
        .build();
    // @formatter:on
  }
}
