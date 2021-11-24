package com.devTest.UnitTestingWithSpringJunitAndMockito.service;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmResponse;
import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmationCriteria;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConfirmationService {

    public EmployeeConfirmResponse confirmEmployee(int employeeId,EmployeeConfirmationCriteria employeeConfirmationCriteria) {
        //confirmation logic like get emp data from repository and update
        return new EmployeeConfirmResponse(employeeConfirmationCriteria.getEmployeeNo(),"confirm", true);
    }
}
