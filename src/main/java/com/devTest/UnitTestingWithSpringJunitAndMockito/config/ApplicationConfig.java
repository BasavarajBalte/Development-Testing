package com.devTest.UnitTestingWithSpringJunitAndMockito.config;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.devTest.UnitTestingWithSpringJunitAndMockito.repository")
@ComponentScans({
        @ComponentScan("com.devTest.UnitTestingWithSpringJunitAndMockito"),
        @ComponentScan("com.devTest.UnitTestingWithSpringJunitAndMockito.model")
})
public class ApplicationConfig {

    @Profile(value = "dev")
    @Bean
    public DataSource getDevDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/demotest");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        return dataSource;
    }

}
