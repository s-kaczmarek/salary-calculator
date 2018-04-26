package com.salarycalculator.Salary.Calculator.Backend.DAL.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FixedData {

    private int id;
    private String countryCode;
    private String taxPercentage;
    private double taxFactor;
    private int fixedCosts;
    private String currencyCode;

}
