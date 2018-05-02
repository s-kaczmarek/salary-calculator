package com.salarycalculator.currency;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRates {

    private List<CurrencyRate> rates;

}

