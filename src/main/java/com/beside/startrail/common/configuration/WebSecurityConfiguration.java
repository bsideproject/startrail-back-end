package com.beside.startrail.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class WebSecurityConfiguration {
  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
    return serverHttpSecurity
        .authorizeExchange().anyExchange().permitAll()
        .and()
        .formLogin().disable()
        .build();
  }
}