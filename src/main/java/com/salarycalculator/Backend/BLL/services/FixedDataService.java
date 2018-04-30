package com.salarycalculator.Salary.Calculator.Backend.BLL.services;

import com.salarycalculator.Salary.Calculator.Backend.DAL.entities.FixedData;
import com.salarycalculator.Salary.Calculator.Backend.DAL.repositories.FixedDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FixedDataService {

    @Autowired
    @Qualifier("fixedData")
    private FixedDataService fixedData;

    public Collection<FixedData> getAllDataEntries() {
        return this.fixedData.getAllDataEntries();
    }

    public FixedData getDataById(int id) {
        return this.fixedData.getDataById(id);
    }

    public void removeDataById(int id) {
        this.fixedData.removeDataById(id);
    }

    public void updateDataById(FixedData FixedData) {
        this.fixedData.updateDataById(FixedData);
    }

    public void insertDataToDb(FixedData FixedData) {
        this.fixedData.insertDataToDb(FixedData);
    }

}
