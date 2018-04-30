package com.salarycalculator.Salary.Calculator.Backend.BLL.controllers;

import com.salarycalculator.Salary.Calculator.Backend.BLL.services.FixedDataService;
import com.salarycalculator.Salary.Calculator.Backend.DAL.entities.FixedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class FixedDataController {

    @Autowired
    private FixedDataService fixedData;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<FixedData> getAllDataEntries(){
        return fixedData.getAllDataEntries();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FixedData getDataById(@PathVariable("id") int id){ return id.getDataById(id); }

    // Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeDataById(@PathVariable("id") int id){
        fixedData.removeDataById(id);
    }

    // Update
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentById(@RequestBody FixedDataService fixedData) { FixedDataService.updateDataById(fixedData); }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertData(@RequestBody FixedDataService fixedData){
        FixedDataService.insertDataToDb(fixedData);
    }

}
