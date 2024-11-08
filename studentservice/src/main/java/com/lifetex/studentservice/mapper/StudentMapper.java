package com.lifetex.studentservice.mapper;


import com.lifetex.studentservice.dto.StudentDto;
import com.lifetex.studentservice.entity.Student;
import com.lifetex.studentservice.form.StudentCreateForm;
import com.lifetex.studentservice.form.StudentUpdateForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentMapper {
    private StudentMapper() {

    }

    public static Student map(StudentCreateForm studentCreateForm) {
        var student = new Student();
        student.setFullName(studentCreateForm.getFullName());
        student.setBirthDate(LocalDate.parse(studentCreateForm.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        student.setGender(Student.Gender.valueOf(studentCreateForm.getGender()));
        student.setPwd(studentCreateForm.getPwd());
        student.setEmail(studentCreateForm.getEmail());
        return student;
    }

    public static StudentDto map(Student student) {
        var dto = new StudentDto();
        dto.setFullName(student.getFullName());
        dto.setBirthDate(student.getBirthDate());
        dto.setGender(student.getGender());
        dto.setPersonalInformation(student.getPersonalInformation().stream().map(PersonalMapper::map).toList());
        return dto;
    }

    public static void map(StudentUpdateForm studentUpdateForm, Student student) {
        student.setFullName(studentUpdateForm.getFullName());
        student.setBirthDate(LocalDate.parse(studentUpdateForm.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        student.setGender(Student.Gender.valueOf(studentUpdateForm.getGender()));
        student.setPwd(studentUpdateForm.getPwd());
    }
}
