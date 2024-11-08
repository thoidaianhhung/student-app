package com.lifetex.studentservice.mapper;

import com.lifetex.studentservice.dto.PersonalDto;
import com.lifetex.studentservice.entity.Personal;
import com.lifetex.studentservice.form.PersonalCreateForm;
import com.lifetex.studentservice.form.PersonalUpdateForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonalMapper {
    private PersonalMapper() {

    }

    public static Personal map(PersonalCreateForm personalCreateForm) {
        var personal = new Personal();
        personal.setFullName(personalCreateForm.getFullName());
        personal.setRelationship(Personal.Relationship.valueOf(personalCreateForm.getRelationship()));
        personal.setBirthDate(LocalDate.parse(personalCreateForm.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        personal.setGender(Personal.Gender.valueOf(personalCreateForm.getGender()));
        return personal;
    }

    public static PersonalDto map(Personal personal) {
        var dto = new PersonalDto();
        dto.setFullName(personal.getFullName());
        dto.setRelationship(personal.getRelationship());
        dto.setBirthDate(personal.getBirthDate());
        dto.setGender(personal.getGender());
        return dto;
    }

    public static void map(PersonalUpdateForm personalUpdateForm, Personal personal) {
        personal.setFullName(personalUpdateForm.getFullName());
        personal.setRelationship(Personal.Relationship.valueOf(personalUpdateForm.getRelationship()));
        personal.setBirthDate(LocalDate.parse(personalUpdateForm.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        personal.setGender(Personal.Gender.valueOf(personalUpdateForm.getGender()));
    }
}
