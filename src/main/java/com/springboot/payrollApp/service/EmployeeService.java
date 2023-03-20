package com.springboot.payrollApp.service;

import com.springboot.payrollApp.dto.EmployeeDTO;
import com.springboot.payrollApp.entity.Employee;
import com.springboot.payrollApp.exception.EmployeePayrollException;
import com.springboot.payrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getall() {
        List<Employee> data = (List<Employee>) employeeRepository.findAll();
        return data;
    }

    @Override
    public Employee postData(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        log.debug("EmpData" + employeeDTO);  // added @Slj4 for showing log
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employeeRepository.findById(id).isPresent()){
            return employee;
        }
        else throw new EmployeePayrollException("Id not found");
    }

    @Override
    public Employee updateById(EmployeeDTO employeeDTO, long id) {
        Employee employee = employeeRepository.findById(id).get();
        if (employeeRepository.findById(id).isPresent()) {
            employee.setName(employeeDTO.getName());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setSalary(employeeDTO.getSalary());
            employee.setNotes(employeeDTO.getNotes());
            employee.setGender(employeeDTO.getGender());
            employee.setStartDate(employeeDTO.getStartDate());
            employeeRepository.save(employee);
            return employee;
        }
        else throw new EmployeePayrollException("Id is Not found for Update");

    }

   public String deleteById(long id) {
       if (employeeRepository.findById(id).isPresent()) {
           employeeRepository.deleteById(id);
           return "Employee Data has been Deleted";
       } else throw new EmployeePayrollException("Id not found to delete");
   }
}


