package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.example.demo.utils.Constants.ENV_DEVELOPMENT;


@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (env.acceptsProfiles(Profiles.of(ENV_DEVELOPMENT))) {
            log.debug("Register CORS configuration");
            registry.addMapping("/api/**")
                    .allowedOrigins("http://localhost:8080")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .allowCredentials(true)
                    .maxAge(3600);
        }
    }



}
