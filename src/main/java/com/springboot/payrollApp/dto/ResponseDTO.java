package com.springboot.payrollApp.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private Object object;

    public ResponseDTO(String message, Object object) {
        this.message = message;
        this.object = object;
    }
}
