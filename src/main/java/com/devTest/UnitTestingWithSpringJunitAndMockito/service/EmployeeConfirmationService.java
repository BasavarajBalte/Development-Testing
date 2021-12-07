package com.devTest.UnitTestingWithSpringJunitAndMockito.service;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmResponse;
import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmationCriteria;
import com.devTest.UnitTestingWithSpringJunitAndMockito.model.EConfirm;
import com.devTest.UnitTestingWithSpringJunitAndMockito.repository.EConfirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConfirmationService {

    @Autowired
    private EConfirmRepository eConfirmRepository;

    public EmployeeConfirmResponse confirmEmployee(int employeeId,EmployeeConfirmationCriteria employeeConfirmationCriteria) {
        //confirmation logic like get emp data from repository and update
        return new EmployeeConfirmResponse(employeeConfirmationCriteria.getEmployeeNo(),"confirm", true);
    }

    public EConfirm saveConfirmEmployee(EConfirm eConfirm) {
        return eConfirmRepository.save(eConfirm);
    }
}
