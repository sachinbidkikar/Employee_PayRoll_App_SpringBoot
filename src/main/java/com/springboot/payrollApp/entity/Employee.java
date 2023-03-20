package com.springboot.payrollApp.entity;

import com.springboot.payrollApp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_Id")
    private  int empId;
    private  int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String salary;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String notes;
    @Column(nullable = false)
    private String startDate;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;


    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.department = employeeDTO.getDepartment();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.notes = employeeDTO.getNotes();
        this.startDate = employeeDTO.getStartDate();
    }

    public Employee() {}

}
