package com.devTest.UnitTestingWithSpringJunitAndMockito.service;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeDTO;
import com.devTest.UnitTestingWithSpringJunitAndMockito.model.Employee;
import com.devTest.UnitTestingWithSpringJunitAndMockito.repository.EmployeeReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeReposiotry employeeReposiotry;

    public EmployeeService(EmployeeReposiotry employeeReposiotry) {
        this.employeeReposiotry = employeeReposiotry;
    }

    public Employee getEmployee(int empId) {
        Optional<Employee> mayBeEmployee = employeeReposiotry.findById(empId);
        return mayBeEmployee.isPresent() ? mayBeEmployee.get() : null;
    }

    public void saveEmployee(EmployeeDTO employeeDto) {
         employeeReposiotry.save(new Employee(employeeDto.getName(),
                employeeDto.getEmployeeNo()));
    }

    public List<Employee> getAllEmployee() {
        return employeeReposiotry.findAll();
    }
}
