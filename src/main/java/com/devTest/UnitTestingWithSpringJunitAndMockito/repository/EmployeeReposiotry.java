package com.devTest.UnitTestingWithSpringJunitAndMockito.repository;

import com.devTest.UnitTestingWithSpringJunitAndMockito.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposiotry  extends JpaRepository<Employee, Integer> {
}
