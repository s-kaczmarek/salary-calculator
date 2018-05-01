package com.salarycalculator.calculator;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CalculatorController {

    private CalculatorService calculatorService;

    @RequestMapping(path = "/calculateNettSalaryInPLN/{countryCode}/{nettSalary}", method = RequestMethod.GET)
    public BigDecimal calculateNettSalaryInPLN(@PathVariable String countryCode, @PathVariable BigDecimal nettSalary){
        return calculatorService.calculateSalaryInPLN(countryCode, nettSalary);
    }

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    BigDecimal salary = new BigDecimal(1000.33);

}
