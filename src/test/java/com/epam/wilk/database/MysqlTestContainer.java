package com.epam.wilk.database;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.testcontainers.containers.MySQLContainer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Singleton
public class MysqlTestContainer {

    @Inject
    MySQLContainer mySQLContainer;

    private void startMysql() {
        mySQLContainer.start();
    }

    @PreDestroy
    public void stopMysql() {
        mySQLContainer.stop();
    }

    @PostConstruct
    public void initDatabase()   {
        startMysql();
        try (Connection connection = mySQLContainer.createConnection("")) {
            Statement statement = connection.createStatement();
            String multiQuery = "DROP TABLE IF EXISTS bar; " +
                    "CREATE TABLE bar (foo VARCHAR(100)); ";
            statement.execute(multiQuery);
        } catch (SQLException ignored) {}
    }

    public void addResultToDatabase(String testName) throws SQLException {
        try (Connection connection = mySQLContainer.createConnection("")) {
            Statement statement = connection.createStatement();
            String multiQuery = String.format("INSERT INTO bar (foo) VALUES ('%s');", testName);
            statement.execute(multiQuery);
        }
    }

    public void printTestResults() throws SQLException {
        try (Connection connection = mySQLContainer.createConnection("")) {
            Statement statement = connection.createStatement();
            statement.execute("SELECT foo FROM bar;");
            try (ResultSet resultSet = statement.getResultSet()) {
                var i = 1;
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(i));
                }
            }
        }
    }
}
