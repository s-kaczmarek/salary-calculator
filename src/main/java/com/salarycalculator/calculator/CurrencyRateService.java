package com.salarycalculator.calculator;

import com.salarycalculator.currency.CurrencyRates;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CurrencyRateService {

    private static final String CURRENCY_RATE_REMOTE_URL = "http://api.nbp.pl/api/exchangerates/rates/a/{currencyCode}/";

    private RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getCurrencyRate(String currencyCode){
        if(currencyCode.equals("PLN")){
            return BigDecimal.valueOf(1);
        }else{
            CurrencyRates cr = restTemplate.getForObject(CURRENCY_RATE_REMOTE_URL, CurrencyRates.class, currencyCode);
            return cr.getRates().get(0).getMid();
        }
    }
}
