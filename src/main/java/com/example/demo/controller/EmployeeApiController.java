package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.EmployeeRepository;
import com.example.demo.database.entity.EmployeeEntity;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeApiController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get all employees
     * http://localhost:8080/employees/all
     * @return
     */
    @GetMapping(value = "/all", produces = "application/json")
    public List<EmployeeEntity> getEmployees() {
        log.info("Getting all employees");
        return employeeRepository.findAll();
    }

    /**
     * Get employee by id
     * http://localhost:8080/employees/find/1
     * @param id
     * @return
     */
    @GetMapping(value = "/find/{id}", produces = "application/json")
    public EmployeeEntity getEmployeeById(@PathVariable("id") String id) {
        log.info("Getting employee by id: {}", id);
        return employeeRepository.findById(Long.valueOf(id)).orElse(null);
    }

    /**
     * Get employees by service years less than
     * http://localhost:8080/employees/serviceyear/5
     * @param serviceYears
     * @return
     */
    @GetMapping(value = "/find", produces = "application/json")
    public List<EmployeeEntity> getEmployeesByServiceYearsLessThan(@RequestParam ("serviceYears") String serviceYears) {
        log.info("Getting employees by service years less than: {}", serviceYears);
        return employeeRepository.findByServiceYearsLessThan(Integer.valueOf(serviceYears));
    }

    /**
     * Add employee
     * http://localhost:8080/employees/add
     * {
            "firstName": "Old",
            "lastName": "Man",
            "email": "super.man@example.com",
            "dateOfBirth": "1200-01-01",
            "salary": 400.00,
            "serviceYears": 1000
        }
     * 
     * @param employee
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json")
    public EmployeeEntity addEmployee(@RequestBody(required = true) EmployeeEntity employee) {
        log.info("Adding employee");
        EmployeeEntity saved = employeeRepository.save(employee);
        log.info("Employee added with id: {}", saved.getId());
        return saved;
    }
    
}
