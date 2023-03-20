package com.springboot.payrollApp.repository;

import com.springboot.payrollApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    // we have to use pass generics values of <Employee, Long> Employee is Entity class. Passing Primary Key i.e id datatype, here its Long.

}
