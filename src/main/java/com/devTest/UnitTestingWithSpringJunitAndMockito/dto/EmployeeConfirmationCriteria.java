package com.devTest.UnitTestingWithSpringJunitAndMockito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeConfirmationCriteria {
    @NonNull
    private String employeeNo;
    private String name;
    private LocalDate joinDate;
    private LocalDate confirmationDate;
}
