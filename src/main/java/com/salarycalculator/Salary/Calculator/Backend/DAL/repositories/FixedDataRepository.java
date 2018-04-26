package com.salarycalculator.Salary.Calculator.Backend.DAL.repositories;

import com.salarycalculator.Salary.Calculator.Backend.DAL.entities.FixedData;
import com.salarycalculator.Salary.Calculator.Backend.DAL.interfaces.IData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fixedData")
public class FixedDataRepository implements IData {

    // Map below will simulate table of Data Base

    private static Map<Integer, FixedData> fixedDataDB;
    static {
        fixedDataDB = new HashMap<Integer, FixedData>(){
            {
                put(1, new FixedData(1, "UK", "25%", 1.25, 600, "GBP"));
                put(2, new FixedData(2, "DE", "20%", 1.20, 800, "EUR"));
                put(3, new FixedData(3, "PL", "19", 1.19, 1200, "PLN"));
            }
        };
    }

    // Method to return collection from HashMap

    @Override
    public Collection<FixedData> getAllDataEntries(){
        return this.fixedDataDB.values();
    }

    @Override
    public FixedData getDataById(int id){
        return this.fixedDataDB.get(id);
    }

    @Override
    public void removeDataById(int id) {
        this.fixedDataDB.remove(id);
    }

    @Override
    public void updateDataById(FixedData FixedData) {
        FixedData fd = fixedDataDB.get(FixedData.getId());

        fd.setCountryCode(FixedData.getCountryCode());
        fd.setTaxPercentage(FixedData.getTaxPercentage());
        fd.setTaxFactor(FixedData.getTaxFactor());
        fd.setFixedCosts(FixedData.getFixedCosts());
        fd.setCurrencyCode(FixedData.getCurrencyCode());

        this.fixedDataDB.put(FixedData.getId(), FixedData);
    }

    @Override
    public void insertDataToDb(FixedData FixedData) {
        this.fixedDataDB.put(FixedData.getId(), FixedData);
    }
}
