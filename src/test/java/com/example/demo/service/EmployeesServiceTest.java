package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.model.Employee;
import com.example.demo.controller.model.EmployeeAddRequest;
import com.example.demo.database.EmployeeRepository;
import com.example.demo.database.entity.EmployeeEntity;

@SpringBootTest
public class EmployeesServiceTest {

    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testGetAllEmployees() {
        int expectedSize = 10;
        List<Employee> employees = employeesService.getAllEmployees();

        assertNotNull(employees);
        assertEquals(expectedSize, employees.size());
    }

    @Test
    public void testGetEmployeeById() {
        Long id = 1L;
        Employee employee = employeesService.getEmployeeById(id);

        assertNotNull(employee);
        assertEquals(id, employee.getId());
    }

    @Test
    public void testGetEmployeesByServiceYearsLessThan() {
        int serviceYears = 5;
        List<Employee> employees = employeesService.getEmployeesByServiceYearsLessThan(serviceYears);

        assertNotNull(employees);
        employees.forEach(employee -> {
            assertNotNull(employee);
            assertNotNull(employee.getServiceYears());
            assertEquals(true, employee.getServiceYears() < serviceYears);
        });
    }

    @Test
    public void testAddEmployee() {

        EmployeeAddRequest employeeRequest = EmployeeAddRequest.builder()
                .firstName("Old")
                .lastName("Man")
                .email("super.man@example.com")
                .dateOfBirth(LocalDate.of(1200, 1, 1))
                .salary(400.00f)
                .serviceYears(1000)
                .address("123 Elm St, Springfield, SP")
                .sinNumber("123 456 789")
                .driverLicenceNumber("D1234567")
                .build();

        Employee addedEmployee = employeesService.addEmployee(employeeRequest);

        int expectedSize = 11;

        assertNotNull(addedEmployee);

        List<Employee> employees = employeesService.getAllEmployees();
        assertEquals(expectedSize, employees.size());

        EmployeeEntity employeeEntity = employeeRepository.findById(addedEmployee.getId()).orElse(null);

        assertNotNull(employeeEntity);
        assertEquals(employeeRequest.getSinNumber(), employeeEntity.getSinNumber());
        assertEquals(employeeRequest.getDriverLicenceNumber(), employeeEntity.getDriverLicenceNumber());

    }

}
