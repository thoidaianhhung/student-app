package com.lifetex.studentservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(
        validatedBy = PersonalIdExistsValidator.class
)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface PersonalIdExists {
    String message() default "Personal id does not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}