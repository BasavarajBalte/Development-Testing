package com.devTest.UnitTestingWithSpringJunitAndMockito.crtls;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmResponse;
import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmationCriteria;
import com.devTest.UnitTestingWithSpringJunitAndMockito.model.EConfirm;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.EmployeeConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/api/{employeeId}/confirm-details")
    public EmployeeConfirmResponse confirmEmployee(@PathVariable("employeeId") int employeeId) {
        return new EmployeeConfirmResponse("001","confirm", true);
    }

    @PostMapping("/api/save/confirm")
    public EConfirm saveConfirmEmployee() {
        EConfirm eConfirm = new EConfirm(1,"001","test", LocalDate.parse("2021-12-02"),
                LocalDate.parse("2021-12-01"));
        EConfirm confirmResponse =
                confirmationService.saveConfirmEmployee(eConfirm);
        return confirmResponse;
    }
}
