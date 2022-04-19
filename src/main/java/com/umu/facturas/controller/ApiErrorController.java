package com.umu.facturas.controller;

import com.umu.facturas.dtos.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@ControllerAdvice
public class ApiErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiError> handleException(Exception exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setPath(request.getServletPath());
        apiError.setTimestamp(LocalDate.now());
        apiError.setError("error.critical");
        apiError.setStatus("500");
        apiError.setMessage("Critical error");

        return ResponseEntity
                .internalServerError()
                .body(apiError);
    }
}
