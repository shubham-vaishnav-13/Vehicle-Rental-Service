package com.project.vehicle.Vehicle.Rental.Service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        // For users
                        .requestMatchers(HttpMethod.GET, "api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/users/**").hasAnyRole("CUSTOMER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "api/users/**").hasRole("ADMIN")


                        // For vehicles
                        .requestMatchers(HttpMethod.GET, "api/vehicles").hasAnyRole("CUSTOMER","ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/vehicles/**").hasAnyRole("CUSTOMER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/vehicles").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/vehicles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "api/vehicles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/vehicles/**").hasRole("ADMIN")


                        // For bookings
                        .requestMatchers(HttpMethod.GET, "api/bookings").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/bookings/**").hasAnyRole("CUSTOMER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/bookings").hasAnyRole("ADMIN","CUSTOMER")
                        .requestMatchers(HttpMethod.PUT, "api/bookings/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/bookings/**").hasAnyRole("CUSTOMER","ADMIN")

                        // For Payment

                        .requestMatchers(HttpMethod.GET, "api/payments").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/payments/**").hasAnyRole("CUSTOMER","ADMIN")




        );









        // use HTTP Basic authentication

        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}