package com.lifetex.studentservice.controller;

import com.lifetex.studentservice.dto.PersonalDto;
import com.lifetex.studentservice.form.PersonalCreateForm;
import com.lifetex.studentservice.form.PersonalUpdateForm;
import com.lifetex.studentservice.service.PersonalService;
import com.lifetex.studentservice.validation.PersonalIdExists;
import com.lifetex.studentservice.validation.StudentIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @GetMapping(path = "/personals")
    public Page<PersonalDto> findAll(Pageable pageable) {
        return personalService.findAll(pageable);
    }

    @GetMapping(path = "/students/{studentId}/personals")
    public Page<PersonalDto> findByStudentId(@PathVariable(name = "studentId") @StudentIdExists Long studentId, Pageable pageable) {
        return personalService.findByStudentId(studentId, pageable);
    }

    @GetMapping(path = "/personals/{id}")
    public PersonalDto findById(@PathVariable(name = "id") @PersonalIdExists Long id) {
        return personalService.findById(id);
    }

    @PostMapping(path = "/students/{studentId}/personals")
    public PersonalDto create(@PathVariable(name = "studentId") @StudentIdExists Long studentId, @Valid @RequestBody PersonalCreateForm form) {
        return personalService.create(studentId, form);
    }

    @PutMapping(path = "/personals/{id}")
    public PersonalDto update(@PathVariable(name = "id") @PersonalIdExists Long id, @Valid @RequestBody PersonalUpdateForm form) {
        return personalService.update(id, form);
    }

    @DeleteMapping(path = "/personals/{id}")
    public void deleteById(@PathVariable(name = "id") @PersonalIdExists Long id) {
        personalService.deleteById(id);
    }
}
