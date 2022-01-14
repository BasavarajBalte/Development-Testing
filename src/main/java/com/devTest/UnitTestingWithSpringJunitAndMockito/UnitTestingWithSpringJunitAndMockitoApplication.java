package com.devTest.UnitTestingWithSpringJunitAndMockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableAutoConfiguration
public class UnitTestingWithSpringJunitAndMockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingWithSpringJunitAndMockitoApplication.class, args);
	}

}
