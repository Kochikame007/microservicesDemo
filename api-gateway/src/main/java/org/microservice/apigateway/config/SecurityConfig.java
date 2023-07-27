package org.microservice.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/*
* This class implements the security filter chain for the apigate-gateway Using spring WebFlux
* */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application using Spring Security.
     *
     * @param http The {@link ServerHttpSecurity} instance to configure security settings.
     * @return A {@link SecurityWebFilterChain} representing the configured security filter chain.
     */
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http){
        return http.csrf(csrf ->csrf.disable())
                .authorizeExchange(exchange -> exchange.pathMatchers("/eureka/**")
                        .permitAll()
                        .anyExchange()
                        .authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())).build();
    }

}
