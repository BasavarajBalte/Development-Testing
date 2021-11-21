package com.devTest.UnitTestingWithSpringJunitAndMockito;

import com.devTest.UnitTestingWithSpringJunitAndMockito.crtls.CalculatorClass;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorMockInjectTest {

    @InjectMocks
    CalculatorClass calculator;

    @Mock
    CalculatorService mockCalculatorService;


    @Test
    public void calculateSum_basic() {
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {1,2,3});
        Assertions.assertEquals(6, calculator.calculateSum());
    }

    @Test
    public void calculateSum_empty() {
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {});
        int sumValue = calculator.calculateSum();
        Mockito.verify(mockCalculatorService, Mockito.times(1))
                .getData();
        Assertions.assertEquals(100, sumValue);
    }

    @Test
    public void calculateSum_oneValue() {
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {5});
        Assertions.assertEquals(5, calculator.calculateSum());
    }

    @Test
    public void calculateMultiplyUsingService() {
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {10,5});
        Assertions.assertEquals(50, calculator.calculator_multiply());
    }
}





