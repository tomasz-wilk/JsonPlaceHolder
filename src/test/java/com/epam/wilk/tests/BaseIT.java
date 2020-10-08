package com.epam.wilk.tests;

import com.epam.wilk.configuration.ConfigurationModule;
import com.epam.wilk.database.MysqlTestContainer;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.lifecycle.LifecycleManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.sql.SQLException;

public class BaseIT {

    @Inject
    private LifecycleManager manager;

    @Inject
    public MysqlTestContainer mysqlTestContainer;

    @BeforeEach
    public void setup() throws Exception{
        Injector injector = LifecycleInjector.builder().withModules(new ConfigurationModule()).createInjector();
        injector.injectMembers(this);
        manager = injector.getInstance(LifecycleManager.class);
        manager.start();
    }

    @AfterEach
    public void printResults(TestInfo testInfo) throws SQLException {
        mysqlTestContainer.addResultToDatabase(testInfo.getDisplayName());
        mysqlTestContainer.printTestResults();
        manager.close();
    }
}
