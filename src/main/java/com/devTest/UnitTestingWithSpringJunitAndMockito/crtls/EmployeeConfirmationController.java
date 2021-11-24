package com.devTest.UnitTestingWithSpringJunitAndMockito.crtls;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmResponse;
import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmationCriteria;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.EmployeeConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeConfirmationController {

    @Autowired
    private EmployeeConfirmationService confirmationService;

    @PostMapping("/api/{employeeId}/confirm")
    public EmployeeConfirmResponse confirmEmployee(@PathVariable("employeeId") int employeeId,
                                                   @RequestBody EmployeeConfirmationCriteria criteria) {
        EmployeeConfirmResponse confirmResponse =  confirmationService.confirmEmployee(employeeId, criteria);
        return confirmResponse;
    }
}
