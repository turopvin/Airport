package org.academy.projects.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class Config {

    @Bean
    public WebSecurityConfigurerAdapter springSecurityConfig(){
        return new SpringSecurityConfig();
    }

    @Bean
    public EmbeddedServletContainerCustomizer sessionTimeoutEmbeddedServletContainerCustomizer(){
        return new SessionTimeoutEmbeddedServletContainerCustomizer();
    }
}
