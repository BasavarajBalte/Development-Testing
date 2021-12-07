package com.devTest.UnitTestingWithSpringJunitAndMockito.springJpaTest;

import com.devTest.UnitTestingWithSpringJunitAndMockito.model.Employee;
import com.devTest.UnitTestingWithSpringJunitAndMockito.repository.EmployeeReposiotry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeReposiotry employeeReposiotry;

    @Test
    public void empty_employee_list() {
        List<Employee> empList =  employeeReposiotry.findAll();
        Assertions.assertEquals(empList.size(), 1);
    }
}
