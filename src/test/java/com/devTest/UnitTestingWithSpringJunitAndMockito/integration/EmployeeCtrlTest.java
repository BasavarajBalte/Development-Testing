package com.devTest.UnitTestingWithSpringJunitAndMockito.integration;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeDTO;
import com.devTest.UnitTestingWithSpringJunitAndMockito.model.Employee;
import com.devTest.UnitTestingWithSpringJunitAndMockito.repository.EmployeeReposiotry;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "/employee-test-configuration.yml")
public class EmployeeCtrlTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeReposiotry employeeReposiotry;

    @Autowired
    private EmployeeService employeeService;

    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper(new YAMLFactory());
    }
    @Test
    public  void employee_read_from_file_test() throws IOException {
        File source = new File("src//test//resources//employee-data.yml");
        Employee employee = mapper.readValue(source, Employee.class);
        Assertions.assertEquals(employee.getEmployeeNo(), "007");
    }

    @Test
    public  void employee_save_test() throws IOException {
        File source = new File("src//test//resources//employee-data.yml");
        Employee employee = mapper.readValue(source, Employee.class);
        employeeService.saveEmployee(new EmployeeDTO(employee.getName(),
                employee.getEmployeeNo()));
       List<Employee> empList =  employeeService.getAllEmployee();
       Assertions.assertEquals(empList.size(), 1);
    }

}
