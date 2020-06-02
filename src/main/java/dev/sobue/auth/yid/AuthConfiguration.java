package dev.sobue.auth.yid;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http.authorizeRequests(
            a ->
                a.antMatchers("/", "/top", "/error", "/webjars/**", "/actuator/health")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .oauth2Login()
        .defaultSuccessUrl("/view");
    // @formatter:on
  }
}
