package com.devTest.UnitTestingWithSpringJunitAndMockito.integration;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EConfirmCtrlIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    public void contextLoads() {
        EmployeeConfirmResponse confirmResponse =
                this.testRestTemplate.getForObject("/employee/api/{employeeId}/confirm-details",
                        EmployeeConfirmResponse.class,1);
        Assertions.assertEquals(confirmResponse.getEmployeeNo(), "001");
    }
}
