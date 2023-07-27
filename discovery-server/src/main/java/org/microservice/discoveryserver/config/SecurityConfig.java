package org.microservice.discoveryserver.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/*
 * This class defines security configuration for the discovery server
 *
 * */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
     *fetching values from application.properties
     */
    @Value("${eureka.username}")
    private String username;

    @Value("${eureka.password}")
    private String password;


    /*
     * Creating dummy username and password using USerDetailsService
     *
     * */
    @Bean
    public UserDetailsService userDetails() {
        UserDetails user = User.builder()
                .username(username)
                .password(password)
                .roles("user")
                .build();

        System.out.println("username =" + username + " password =" + password);

        return new InMemoryUserDetailsManager(user);

    }

    /*
     * Defining password encryption class
     * */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    /*
     * Configures SecurityFilterChain for the application using spring security
     * @param http The {@link HttpSecurity} instance to configure security settings
     * @return A {@link SecurityFilterChain} represents the configured security filter chain
     * @throws Exception if an error occurs while configuring the security
     * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req.anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
