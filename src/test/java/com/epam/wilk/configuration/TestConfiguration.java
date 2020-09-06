package com.epam.wilk.configuration;

import org.aeonbits.owner.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
@ComponentScan(basePackages = {"com.epam.wilk"})
public class TestConfiguration {
    public static final String MYSQL_IMAGE = new DockerImageName("mysql:5.7.22").toString();

    @Bean
    public TestProperties testProperties() {
        return ConfigFactory.create(TestProperties.class);
    }

    @Bean
    public String baseUrl() {
        return testProperties().getBaseUrl();
    }

    @Bean
    public MySQLContainer<?> mySQLContainer(){
        return new MySQLContainer<>(MYSQL_IMAGE).withUrlParam("allowMultiQueries", "true");
    }
}
