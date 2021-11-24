package com.devTest.UnitTestingWithSpringJunitAndMockito;

import com.devTest.UnitTestingWithSpringJunitAndMockito.crtls.EmployeeConfirmationController;
import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmationCriteria;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.EmployeeConfirmationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@WebMvcTest(controllers = EmployeeConfirmationController.class)
public class EmployeeConfirmationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeConfirmationService confirmationService;

    @Test
    public void invalid_input_throws_Exception() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/api/{employeeId}/confirm")
        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void validateInput_return200() throws Exception {
        EmployeeConfirmationCriteria criteria =
                new EmployeeConfirmationCriteria("001", "Ram", LocalDate.of(2021,10,01),
                        LocalDate.of(2021,11,24));
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/api/{employeeId}/confirm", 10)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(criteria)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

