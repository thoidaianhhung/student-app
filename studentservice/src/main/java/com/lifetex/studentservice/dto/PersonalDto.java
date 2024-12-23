package com.lifetex.studentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lifetex.studentservice.entity.Personal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class PersonalDto {
    private String fullName;

    private Personal.Relationship relationship;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private Personal.Gender gender;
}
