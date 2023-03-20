package com.springboot.payrollApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private int id;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employeould Start with at least one Capital letter & length of name cant be less than 3 ")
    private String name;

    @Min(value = 30000, message = "min Wage should be more than 30000")
    @PositiveOrZero(message = "Salary should be an valid ")
    private String salary;

    @Pattern(regexp = "male|female", message = "gender needs to be male or female")
    private String gender;

    @NotBlank(message = "note cannot be empty")
    private String notes;

    @NotEmpty(message = "Start cant be Empty")
    private String startDate;

    @NotNull(message = "department should not be Empty")
    private List<String> department;


}
