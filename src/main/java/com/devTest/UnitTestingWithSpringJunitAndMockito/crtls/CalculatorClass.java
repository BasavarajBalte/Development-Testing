package com.devTest.UnitTestingWithSpringJunitAndMockito.crtls;

import com.devTest.UnitTestingWithSpringJunitAndMockito.service.CalculatorService;
import org.springframework.stereotype.Component;

@Component
public class CalculatorClass {

    private CalculatorService calculatorService;

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int calculateSum() {
        int[] data =  calculatorService.getData();
        int sum = 0;
        for(int value:data) {
            sum += value;
        }
        return sum;
    }


    public int calculator_multiply() {
        int[] data =  calculatorService.getData();
        int multiply = 1;
        for(int value:data) {
            multiply *= value;
        }
        return multiply;
    }
}
