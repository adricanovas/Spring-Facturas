package com.umu.facturas.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiError {
    public LocalDate timestamp;
    public String status;
    public String error;
    public String message;
    public String path;
}

