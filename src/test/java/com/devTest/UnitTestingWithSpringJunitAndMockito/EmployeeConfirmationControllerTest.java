package com.devTest.UnitTestingWithSpringJunitAndMockito;

import com.devTest.UnitTestingWithSpringJunitAndMockito.crtls.EmployeeConfirmationController;
import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmResponse;
import com.devTest.UnitTestingWithSpringJunitAndMockito.dto.EmployeeConfirmationCriteria;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.EmployeeConfirmationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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
                //pass request params .param("test",1)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void validate_get_request_response_with_status200() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/employee/api/{employeeId}/confirm-details", 10)
        .contentType("application/json"))
                .andReturn();
        EmployeeConfirmResponse confirmResponse = objectMapper
                .readValue(result.getResponse().getContentAsString(), EmployeeConfirmResponse.class);
        Assertions.assertEquals("001", confirmResponse.getEmployeeNo());

    }

    @Test
    public void validate_post_request_response_with_status200() throws Exception{
        EmployeeConfirmationCriteria criteria =
                new EmployeeConfirmationCriteria("001", "Ram", LocalDate.of(2021,10,01),
                        LocalDate.of(2021,11,24));
        Mockito.when(confirmationService.confirmEmployee(Mockito.anyInt(),
                Mockito.any())).thenReturn(new EmployeeConfirmResponse("001", "confirm", true));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/employee/api/{employeeId}/confirm", 10)
                .contentType("application/json")
        .content(objectMapper.writeValueAsString(criteria)))
                .andReturn();
        EmployeeConfirmResponse confirmResponse = objectMapper
                .readValue(result.getResponse().getContentAsString(), EmployeeConfirmResponse.class);
        Assertions.assertEquals("001", confirmResponse.getEmployeeNo());

    }

    @Test
    public void whenNullValue_responseWith400() throws Exception {
        EmployeeConfirmationCriteria criteria =
                new EmployeeConfirmationCriteria(null, "Ram", LocalDate.of(2021,10,01),
                        LocalDate.of(2021,11,24));
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/api/{employeeId}/confirm",10)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(criteria)))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError());
    }

    @Test
    public void validate_arg_pass_to_service_method() throws Exception{
        EmployeeConfirmationCriteria criteria =
                new EmployeeConfirmationCriteria("001", "Ram", LocalDate.of(2021,10,01),
                        LocalDate.of(2021,11,24));
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/api/{employeeId}/confirm", 10)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(criteria)))
                //pass request params .param("test",1)
               // .andExpect(MockMvcResultMatchers.content().json(""))
                .andExpect(MockMvcResultMatchers.status().isOk());


        ArgumentCaptor<EmployeeConfirmationCriteria> confirmCriteriaCapture =
                ArgumentCaptor.forClass(EmployeeConfirmationCriteria.class);
        Mockito.verify(confirmationService,Mockito.times(1))
                .confirmEmployee(Mockito.eq(10),confirmCriteriaCapture.capture());
        Assertions.assertEquals(confirmCriteriaCapture.getValue().getEmployeeNo(),
                "001");
    }
}

