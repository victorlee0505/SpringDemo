package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.Employee;
import com.example.demo.controller.model.EmployeeAddRequest;
import com.example.demo.controller.model.EmployeeAddResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeesController implements EmployeesApi {
    @Override
    public ResponseEntity<EmployeeAddResponse> addEmployee(@Valid EmployeeAddRequest employeeAddRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEmployee'");
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmployees'");
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeById'");
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeesByServiceYearsLessThan(@NotNull @Valid Integer serviceYears) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeesByServiceYearsLessThan'");
    }

}
