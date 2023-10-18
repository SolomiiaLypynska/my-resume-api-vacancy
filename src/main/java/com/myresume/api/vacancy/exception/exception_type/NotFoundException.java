package com.myresume.api.vacancy.exception.exception_type;


import com.myresume.api.vacancy.exception.CustomValidationException;

public class NotFoundException extends CustomValidationException {
    public NotFoundException(String customMessage) {
        super(customMessage);
    }
}
