package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.Employee;
import com.example.demo.controller.model.EmployeeAddRequest;
import com.example.demo.controller.model.EmployeeAddResponse;
import com.example.demo.service.EmployeesService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EmployeesController implements EmployeesApi {

    private final EmployeesService employeesService;

    @Override
    public ResponseEntity<EmployeeAddResponse> addEmployee(@Valid EmployeeAddRequest employeeAddRequest) {
        log.info("Adding employee: {}", employeeAddRequest);
        return ResponseEntity.ok(new EmployeeAddResponse().employee(employeesService.addEmployee(employeeAddRequest)));
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        log.info("Getting all employees");
        return ResponseEntity.ok(employeesService.getAllEmployees());
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(String id) {
        log.info("Getting employee by id: {}", id);
        return ResponseEntity.ok(employeesService.getEmployeeById(Long.valueOf(id)));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeesByServiceYearsLessThan(@NotNull @Valid Integer serviceYears) {
        log.info("Getting employees by service years less than: {}", serviceYears);
        return ResponseEntity.ok(employeesService.getEmployeesByServiceYearsLessThan(serviceYears));
    }

}
