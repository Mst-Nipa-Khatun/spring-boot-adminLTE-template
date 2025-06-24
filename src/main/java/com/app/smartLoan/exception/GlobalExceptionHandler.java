package com.app.smartLoan.exception;

import com.app.smartLoan.dto.Response;
import com.app.smartLoan.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return ResponseBuilder.getFailResponse(HttpStatus.METHOD_NOT_ALLOWED,
                null,
                "This request method is not supported for the requested endpoint.");
    }

    @ExceptionHandler(Exception.class)
    public Response handleGenericException(Exception ex) {
        return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                null, "" + ex.getMessage() + ex);
    }
}
