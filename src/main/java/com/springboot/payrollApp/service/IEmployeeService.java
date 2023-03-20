package com.springboot.payrollApp.service;

import com.springboot.payrollApp.dto.EmployeeDTO;
import com.springboot.payrollApp.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getall();

    Employee postData(EmployeeDTO employeeDTO);

    Optional<Employee> getById(long id);

    Employee updateById(EmployeeDTO employeeDTO, long id);

    String deleteById(long id);
}
