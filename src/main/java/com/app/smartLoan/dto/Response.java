package com.app.smartLoan.dto;

import lombok.Data;

@Data
public class Response {
    private Integer statusCode;
    private String status;
    private String message;
    private Object content;
}
