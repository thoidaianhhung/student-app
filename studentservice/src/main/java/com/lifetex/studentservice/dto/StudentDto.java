package com.lifetex.studentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lifetex.studentservice.entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class StudentDto {

    private String fullName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private Student.Gender gender;

    private List<PersonalDto> personalInformation;
}
