package com.myresume.api.vacancy.exception;

import lombok.Getter;

@Getter
public class CustomValidationException extends RuntimeException {
    private final String customMessage;

    public CustomValidationException(String customMessage) {
        this.customMessage = customMessage;
    }
}