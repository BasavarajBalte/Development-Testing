package com.devTest.UnitTestingWithSpringJunitAndMockito;

import com.devTest.UnitTestingWithSpringJunitAndMockito.model.Employee;
import com.devTest.UnitTestingWithSpringJunitAndMockito.repository.EConfirmRepository;
import com.devTest.UnitTestingWithSpringJunitAndMockito.repository.EmployeeReposiotry;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockBeanInjectionTest {

    @Mock
    private EConfirmRepository eConfirmRepository;

    @Mock
    private EmployeeReposiotry employeeReposiotry;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void return_empty_on_get_emp_method() {
        List<Employee> empList = new ArrayList<>();
        Mockito.when(employeeService.getAllEmployee()).thenReturn(empList);
        Assertions.assertEquals(0, employeeService.getAllEmployee().size());
    }
}
