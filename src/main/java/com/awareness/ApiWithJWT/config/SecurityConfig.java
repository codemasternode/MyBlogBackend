package com.awareness.ApiWithJWT.config;

import com.awareness.ApiWithJWT.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        prePostEnabled = true,
        securedEnabled = true
)
public class SecurityConfig {

    @Autowired
    CustomUserDetailService userDetailService;


}
