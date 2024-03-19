package com.example.to_do_list.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionValidation implements ConstraintValidator<ValidDescription, String> {
    @Override
    public void initialize(ValidDescription constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        return input == null || input.matches("\\S[a-zA-Z0-9\\s]+\\S");
    }
}
