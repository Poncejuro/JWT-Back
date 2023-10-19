package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      http
              .authorizeHttpRequests((authz) -> authz
                      .requestMatchers("/publico/**").permitAll()
                      .requestMatchers("/admin/**").hasRole("ADMIN")
                     .anyRequest().authenticated()
             );

      http
              .formLogin(Customizer.withDefaults());
      http
              .httpBasic(Customizer.withDefaults());

      return http.build();

    }


    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);



    @Bean
    UserDetailsServiceImpl userDetailsService(){
        logger.debug("Configurando UserDetailsServiceImpl");
        return new UserDetailsServiceImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        logger.debug("Se encripta");
        return new BCryptPasswordEncoder();  }

}
