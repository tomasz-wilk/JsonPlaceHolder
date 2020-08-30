package com.epam.wilk.configuration;

import org.aeonbits.owner.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ComponentScan(basePackages = {"com.epam.wilk"})
public class TestConfiguration {

    @Bean
    public TestProperties testProperties() {
        return ConfigFactory.create(TestProperties.class);
    }

    @Bean
    public String baseUrl() {
        return testProperties().getBaseUrl();
    }
}
