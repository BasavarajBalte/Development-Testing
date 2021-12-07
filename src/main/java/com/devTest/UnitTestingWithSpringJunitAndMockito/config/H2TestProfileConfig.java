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
public class H2TestProfileConfig {
    @Profile(value = "test")
    @Bean
    public DataSource getTestDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }
}
