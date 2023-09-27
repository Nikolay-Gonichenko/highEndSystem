package ru.itmo.highendsystem.config;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
public class CustomPostgreSQLContainer {

    public static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:15-alpine");

    @BeforeAll
    public static void setUp() {
        postgresqlContainer.start();
    }

    @AfterAll
    public static void setDown() {
        postgresqlContainer.stop();
    }

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", postgresqlContainer::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", postgresqlContainer::getPassword);
        dynamicPropertyRegistry.add("spring.datasource.driver-class-name", postgresqlContainer::getDriverClassName);
    }

}
