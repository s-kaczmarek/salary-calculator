package com.salarycalculator.currency;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class FixedData {

    private BigDecimal taxFactor;
    private BigDecimal fixedCosts;
    private String currencyCode;

}
