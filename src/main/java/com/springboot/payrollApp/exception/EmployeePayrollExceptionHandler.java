package com.springboot.payrollApp.exception;

import com.springboot.payrollApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

//@ControllerAdvice is very useful to handle exceptions all at one place when you have multiple layers doing different work.

@ControllerAdvice // It is used so that Spring Framework can call this class to handle Exceptions thrown during processing REST API Request.
public class EmployeePayrollExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException( MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception While processing RESt Request", errMesg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
        ResponseDTO respDTO = new ResponseDTO("Exception While processing RESt Request", exception.getMessage());
        return new ResponseEntity<>(respDTO, HttpStatus.BAD_REQUEST);
    }
}
