package com.epam.wilk.tests;

import com.epam.wilk.database.MysqlTestContainer;
import com.epam.wilk.configuration.TestConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

@SpringBootTest
@ContextConfiguration(classes = {TestConfiguration.class})
@ExtendWith(SpringExtension.class)
public class BaseIT {

    @Autowired
    public MysqlTestContainer mysqlTestContainer;

    @AfterEach
    public void printResults(TestInfo testInfo) throws SQLException {
        mysqlTestContainer.addResultToDatabase(testInfo.getDisplayName());
        mysqlTestContainer.printTestResults();
    }
}
