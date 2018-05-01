package com.salarycalculator.currency;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DataRepository {

    private static Map<String, FixedData> fixedDataMap;
    static {
        fixedDataMap = new HashMap<String, FixedData>(){
            {
                put("UK", new FixedData( new BigDecimal(0.25), new BigDecimal(600), "GBP"));
                put("DE", new FixedData( new BigDecimal(0.20), new BigDecimal(800), "EUR"));
                put("PL", new FixedData( new BigDecimal(0.19), new BigDecimal(1200), "PLN"));
            }
        };
    }

    public FixedData getDataByCountry(String countryCode){
        return fixedDataMap.get(countryCode);
    }
}
