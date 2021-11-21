package com.devTest.UnitTestingWithSpringJunitAndMockito;

import com.devTest.UnitTestingWithSpringJunitAndMockito.crtls.CalculatorClass;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//@SpringBootTest
public class CalculatorMockRefactorTest {
    CalculatorClass calculator = new CalculatorClass();
    CalculatorService mockCalculatorService = Mockito.mock(CalculatorService.class);

    @BeforeEach
    public void setUp() {
        calculator.setCalculatorService(mockCalculatorService);
    }
    @Test
    public void calculateSum_basic() {
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {1,2,3});
        Assertions.assertEquals(6, calculator.calculateSum());
    }

    @Test
    public void calculateSum_empty() {
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {});
        Assertions.assertEquals(0, calculator.calculateSum());
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





