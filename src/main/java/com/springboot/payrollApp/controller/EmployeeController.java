package com.springboot.payrollApp.controller;

import com.springboot.payrollApp.dto.EmployeeDTO;
import com.springboot.payrollApp.dto.ResponseDTO;
import com.springboot.payrollApp.entity.Employee;
import com.springboot.payrollApp.service.EmployeeService;
import com.springboot.payrollApp.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/start")
    public String sayHello(){
        return "Welcome to Employee Pay Roll APP";
    }

//    http://localhost:8080/app/get
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> showAll(){
        List<Employee> employeeList =  employeeService.getall();
        ResponseDTO responseDTO = new ResponseDTO("All Details are found",employeeList);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
         }
    //http://localhost:8080/app/post
    @PostMapping("/post")
   public ResponseEntity<ResponseDTO> postData(@Valid @RequestBody EmployeeDTO employeeDTO){      //@Valid is used to enable validation.required to ensure the request meet the constraints specified for JSON elements.
        Employee employee = employeeService.postData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Added",employee);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

   // http://localhost:8080/app/getById/1
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable long id){
        Optional<Employee> employee = employeeService.getById(id);
        ResponseDTO responseDTO = new ResponseDTO("Details Found By "+id,employee);
        return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
    }

//    http://localhost:8080/app/update/2
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById(@PathVariable long id, @Valid @RequestBody EmployeeDTO employeeDTO){   //@valid is used for validation of attributes which we created in DTO class
        Employee employee = employeeService.updateById(employeeDTO,id);
        ResponseDTO responseDTO = new ResponseDTO("Data Upadated of" +id, employee);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

//    http://localhost:8080/app/delete/2
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable long id){
        String msg = employeeService.deleteById(id);
        ResponseDTO responseDTO = new ResponseDTO("Data has Deleted", msg);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }
}
