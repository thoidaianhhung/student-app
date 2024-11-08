package com.lifetex.studentservice.validation;

import com.lifetex.studentservice.repository.PersonalRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonalIdExistsValidator implements ConstraintValidator<PersonalIdExists, Long> {
    private PersonalRepository personalRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return personalRepository.existsById(id);
    }
}
