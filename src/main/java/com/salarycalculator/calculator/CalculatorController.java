package com.salarycalculator.calculator;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @RequestMapping(path = "/calculateNettSalaryInPLN/{countryCode}/{nettSalary}", method = RequestMethod.GET)
    public BigDecimal calculateNettSalaryInPLN(@PathVariable String countryCode, @PathVariable BigDecimal nettSalary){
            return calculatorService.calculateSalaryInPLN(countryCode, nettSalary);
    }

}
