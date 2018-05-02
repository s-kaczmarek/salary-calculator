package com.salarycalculator.calculator;

import com.salarycalculator.currency.DataRepository;
import com.salarycalculator.currency.FixedData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class  CalculatorService {

    private static final int DAYS_OF_MONTH = 22;
    private DataRepository dataRepository;
    private CurrencyRateService currencyRateService;

    public CalculatorService(DataRepository dataRepository, CurrencyRateService currencyRateService) {
        this.dataRepository = dataRepository;
        this.currencyRateService = currencyRateService;
    }

    public BigDecimal calculateSalaryInPLN(String countryCode, BigDecimal nettSalary) {
        FixedData dataByCountry = dataRepository.getDataByCountry(countryCode);
        BigDecimal currencyRate = currencyRateService.getCurrencyRate("USD");

        BigDecimal taxFactor = dataByCountry.getTaxFactor();
        BigDecimal fixedCost = dataByCountry.getFixedCosts();

        return nettSalary
                .multiply(new BigDecimal(DAYS_OF_MONTH))
                .subtract(fixedCost)
                .multiply(BigDecimal.ONE.subtract(taxFactor))
                .multiply(currencyRate)
                .setScale(2, RoundingMode.CEILING);

    }
}
