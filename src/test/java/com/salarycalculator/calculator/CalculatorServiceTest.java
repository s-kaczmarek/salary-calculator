package com.salarycalculator.calculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @MockBean
    private CurrencyRateService currencyRateService;

    @Test
    public void shouldGetRightValueForUK() {
        Mockito.when(currencyRateService.getCurrencyRate(Mockito.any())).thenReturn(new BigDecimal("4"));
        BigDecimal salaryForUK = calculatorService.calculateSalaryInPLN("UK", new BigDecimal(100.00));
        Assertions.assertThat(salaryForUK).isEqualTo("4200.00");
    }

    @Test
    public void shouldGetRightValueForDE() {
        Mockito.when(currencyRateService.getCurrencyRate(Mockito.any())).thenReturn(new BigDecimal("4"));
        BigDecimal salaryForUK = calculatorService.calculateSalaryInPLN("DE", new BigDecimal(100.00));
        Assertions.assertThat(salaryForUK).isEqualTo("3840.00");
    }

    @Test
    public void shouldGetRightValueForPL() {
        Mockito.when(currencyRateService.getCurrencyRate(Mockito.any())).thenReturn(new BigDecimal("1"));
        BigDecimal salaryForUK = calculatorService.calculateSalaryInPLN("PL", new BigDecimal(100.00));
        Assertions.assertThat(salaryForUK).isEqualTo("582.00");
    }

    @Test
    public void shouldGetZeroIfZeroPassedAsArgument() {
        Mockito.when(currencyRateService.getCurrencyRate(Mockito.any())).thenReturn(new BigDecimal("4"));
        BigDecimal salaryForUK = calculatorService.calculateSalaryInPLN("UK", new BigDecimal(0.00));
        Assertions.assertThat(salaryForUK).isEqualTo("0");
    }

    @Test
    public void shouldGetZeroIfNegativeValuePassedAsArgument() {
        Mockito.when(currencyRateService.getCurrencyRate(Mockito.any())).thenReturn(new BigDecimal("4"));
        BigDecimal salaryForUK = calculatorService.calculateSalaryInPLN("UK", new BigDecimal(-100.30));
        Assertions.assertThat(salaryForUK).isEqualTo("0.00");
    }
}
