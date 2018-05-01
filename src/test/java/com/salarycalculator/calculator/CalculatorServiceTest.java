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
    public void shouldGetSalaryInPLN() {
        Mockito.when(currencyRateService.getCurrencyRate(Mockito.any())).thenReturn(new BigDecimal("4"));
        BigDecimal salaryForGermany = calculatorService.calculateSalaryInPLN("DE", new BigDecimal(100.00));
        Assertions.assertThat(salaryForGermany).isEqualTo("4480.00");
    }
}
