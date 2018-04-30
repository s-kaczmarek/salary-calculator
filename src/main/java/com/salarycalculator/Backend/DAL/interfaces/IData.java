package com.salarycalculator.Salary.Calculator.Backend.DAL.interfaces;

import com.salarycalculator.Salary.Calculator.Backend.DAL.entities.FixedData;

public interface IData <T> {

    public T getAllDataEntries();
    public T getDataById(int id);
    public void removeDataById(int id);
    public void updateDataById(FixedData FixedData);
    public void insertDataToDb(FixedData FixedData);

}
