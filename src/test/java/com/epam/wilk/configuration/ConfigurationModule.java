package com.epam.wilk.configuration;

import com.epam.wilk.database.MysqlTestContainer;
import com.epam.wilk.endpoints.AlbumEndpoint;
import com.epam.wilk.endpoints.PostEndpoint;
import com.epam.wilk.steps.AlbumSteps;
import com.epam.wilk.steps.PostSteps;
import com.google.inject.AbstractModule;
import org.aeonbits.owner.ConfigFactory;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

public class ConfigurationModule extends AbstractModule {

    public static final String MYSQL_IMAGE = new DockerImageName("mysql:5.7.22").toString();

    @Override
    protected void configure() {
        bind(MySQLContainer.class).toInstance(new MySQLContainer<>(MYSQL_IMAGE).withUrlParam("allowMultiQueries", "true"));
        bind(TestProperties.class).toInstance(ConfigFactory.create(TestProperties.class));
        bind(PostEndpoint.class);
        bind(AlbumEndpoint.class);
        bind(AlbumSteps.class);
        bind(PostSteps.class);
        bind(MysqlTestContainer.class);
    }
}
