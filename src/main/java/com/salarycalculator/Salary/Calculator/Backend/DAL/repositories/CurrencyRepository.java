package com.salarycalculator.Salary.Calculator.Backend.DAL.repositories;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyRepository {

    @Id
    @GeneratedValue(strategy = GeneratationType.IDENTITY)
    int id;
}
