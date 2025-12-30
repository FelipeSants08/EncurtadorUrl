package com.santana.encurtador.exception;

import org.springframework.validation.FieldError;

public record ValidationErrorMessage(String field, String message) {
    public ValidationErrorMessage(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
