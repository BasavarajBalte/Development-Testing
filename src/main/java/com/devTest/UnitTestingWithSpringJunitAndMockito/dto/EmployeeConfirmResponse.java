package com.devTest.UnitTestingWithSpringJunitAndMockito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeConfirmResponse {
    private String employeeNo;
    private String status;
    private boolean isConfirmed;
}
