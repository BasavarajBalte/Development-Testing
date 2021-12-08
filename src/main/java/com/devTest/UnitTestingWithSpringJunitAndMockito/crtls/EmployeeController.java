package com.devTest.UnitTestingWithSpringJunitAndMockito.crtls;

import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeDTO;
import com.devTest.UnitTestingWithSpringJunitAndMockito.model.Employee;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable("empId") int empId) {
        return employeeService.getEmployee(empId);
    }

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDto) {
        employeeService.saveEmployee(employeeDto);
        return "Success Msg";
    }


}
