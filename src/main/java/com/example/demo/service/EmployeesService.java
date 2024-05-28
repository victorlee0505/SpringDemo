package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.controller.model.Employee;
import com.example.demo.controller.model.EmployeeAddRequest;
import com.example.demo.database.EmployeeRepository;
import com.example.demo.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeesService {

    // This is equivalent to the @Autowired with @RequiredArgsConstructor
    private final EmployeeRepository employeeRepository;
    
    private final EmployeeMapper employeeMapper;
    
    public List<Employee> getAllEmployees() {
        log.info("Getting all employees");
        return employeeRepository.findAll().stream().map(employeeMapper::mapToEmployee).collect(Collectors.toList());
    }

    public Employee getEmployeeById(Long id) {
        log.info("Getting employee by id: {}", id);
        return employeeMapper.mapToEmployee(employeeRepository.findById(id).orElse(null));
    }

    public List<Employee> getEmployeesByServiceYearsLessThan(Integer serviceYears) {
        log.info("Getting employees by service years less than: {}", serviceYears);
        return employeeRepository.findByServiceYearsLessThan(serviceYears).stream().map(employeeMapper::mapToEmployee).collect(Collectors.toList());
    }

    public Employee addEmployee(EmployeeAddRequest employee) {
        log.info("Adding employee: {}", employee);
        return employeeMapper.mapToEmployee(employeeRepository.save(employeeMapper.mapToEmployeeEntity(employee)));
    }
}
