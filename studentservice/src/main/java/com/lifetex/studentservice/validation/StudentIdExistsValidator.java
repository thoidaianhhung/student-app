package com.lifetex.studentservice.validation;

import com.lifetex.studentservice.repository.StudentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentIdExistsValidator implements ConstraintValidator<StudentIdExists, Long> {
    private StudentRepository studentRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return studentRepository.existsById(id);
    }
}
