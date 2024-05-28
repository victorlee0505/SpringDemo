package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.controller.model.Employee;
import com.example.demo.controller.model.EmployeeAddRequest;
import com.example.demo.database.entity.EmployeeEntity;

/**
 * EmployeeEntity has sinNumber and driverLicenceNumber fields that are not present in Employee
 * Employee object do not contain confidential information
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee mapToEmployee(EmployeeEntity employeeEntity);

    @Mapping(target = "id", ignore = true)
    EmployeeEntity mapToEmployeeEntity(EmployeeAddRequest employee);
}
