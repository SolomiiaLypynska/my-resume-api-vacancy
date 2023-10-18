package com.myresume.api.vacancy.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ApiError {
    private HttpStatus status;
    private String message;

    private String time;

    private String error;
    private String path;

    public ApiError(HttpStatus status, String error, String path) {
        this.status = status;
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        this.error = error;
        this.path = path;
    }
}
