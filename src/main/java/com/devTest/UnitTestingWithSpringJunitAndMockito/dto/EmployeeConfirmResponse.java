package com.devTest.UnitTestingWithSpringJunitAndMockito.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeConfirmResponse {
    private String employeeNo;
    private String status;
    private boolean isConfirmed;
}
