package com.example.to_do_list.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidDescriptionValidation.class)
@Documented
public @interface ValidDescription {
    String message() default "La descripcion no puede estar formado por espacios en blanco." +
            "Tampoco, debe comenzar ni terminar con espacios en blanco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}