package com.myresume.api.vacancy.exception.exception_type;

import com.myresume.api.vacancy.exception.CustomValidationException;

public class BadRequestException extends CustomValidationException {
    public BadRequestException(String customMessage) {
        super(customMessage);
    }
}