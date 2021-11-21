package com.devTest.UnitTestingWithSpringJunitAndMockito;

import com.devTest.UnitTestingWithSpringJunitAndMockito.crtls.CalculatorClass;
import com.devTest.UnitTestingWithSpringJunitAndMockito.service.CalculatorService;
import org.junit.jupiter.api.*;

//@SpringBootTest
public class CalculatorTest {
    /*@Test
    public void calculateSum_basic() {
        CalculatorClass business = new CalculatorClass();
        int actualResult = business.calculateSum();
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }*/

    @Test
    public void calculateSum_empty() {
        CalculatorClass calculator = new CalculatorClass();
        calculator.setCalculatorService(new CalculatorEmptyServiceStub());
        int actualResult = calculator.calculateSum();
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult); //throw exception if expectedResult and actualResult not mashed
    }

    @Test
    public void calculateSum_oneValue() {
        CalculatorClass calculator = new CalculatorClass();
        calculator.setCalculatorService(new CalculatorOneValueServiceStub());
        int actualResult = calculator.calculateSum();
        int expectedResult = 5;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateMultiplyUsingService() {
        CalculatorClass calculate = new CalculatorClass();
        calculate.setCalculatorService(new CalculatorServiceStub());
        int actualResult = calculate.calculator_multiply();
        int expectedResult = 50;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}

class CalculatorServiceStub implements CalculatorService {

    @Override
    public int[] getData() {
        return new int[]{5,10};
    }
}

class CalculatorEmptyServiceStub implements CalculatorService {

    @Override
    public int[] getData() {
        return new int[]{};
    }
}

class CalculatorOneValueServiceStub implements CalculatorService {

    @Override
    public int[] getData() {
        return new int[]{5};
    }
}




