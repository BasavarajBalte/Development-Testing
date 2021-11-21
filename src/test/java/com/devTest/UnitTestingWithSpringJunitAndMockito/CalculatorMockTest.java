package com.devTest.UnitTestingWithSpringJunitAndMockito;

import com.devTest.UnitTestingWithSpringJunitAndMockito.crtls.CalculatorClass;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//@SpringBootTest
public class CalculatorMockTest {
    @Test
    public void calculateSum_basic() {
        CalculatorClass business = new CalculatorClass();
        CalculatorService mockCalculatorService = Mockito.mock(CalculatorService.class);
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {1,2,3});
        business.setCalculatorService(mockCalculatorService);
        int actualResult = business.calculateSum();
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        CalculatorClass calculator = new CalculatorClass();
        CalculatorService mockCalculatorService = Mockito.mock(CalculatorService.class);
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {});
        calculator.setCalculatorService(mockCalculatorService);
        int actualResult = calculator.calculateSum();
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult); //throw exception if expectedResult and actualResult not mashed
    }

    @Test
    public void calculateSum_oneValue() {
        CalculatorClass calculator = new CalculatorClass();
        CalculatorService mockCalculatorService = Mockito.mock(CalculatorService.class);
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {5});
        calculator.setCalculatorService(mockCalculatorService);
        int actualResult = calculator.calculateSum();
        int expectedResult = 5;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateMultiplyUsingService() {
        CalculatorClass calculate = new CalculatorClass();
        CalculatorService mockCalculatorService = Mockito.mock(CalculatorService.class);
        Mockito.when(mockCalculatorService.getData()).thenReturn(new int[] {10,5});
        calculate.setCalculatorService(mockCalculatorService);
        int actualResult = calculate.calculator_multiply();
        int expectedResult = 50;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}





