package com.lifetex.studentservice.controller;

import com.lifetex.studentservice.dto.LoginResponseDTO;
import com.lifetex.studentservice.dto.StudentDto;
import com.lifetex.studentservice.form.LoginRequestForm;
import com.lifetex.studentservice.form.StudentCreateForm;
import com.lifetex.studentservice.form.StudentUpdateForm;
import com.lifetex.studentservice.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody StudentCreateForm studentCreateForm) {

        return studentService.registerUser(studentCreateForm);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginRequestForm loginRequestForm) {
        return studentService.loginUser(loginRequestForm);
    }

    @GetMapping("/students")
    public Page<StudentDto> findAllStudents(Pageable pageable) {
        return studentService.findAllStudents(pageable);
    }

    @GetMapping("/students/{email}")
    public StudentDto findByEmail(@PathVariable(value = "email") String email) {
        return studentService.findByEmail(email);
    }

    @PutMapping("/students/{id}")
    public StudentDto updateStudent(@PathVariable(value = "id") Long id, @Valid @RequestBody StudentUpdateForm customerUpdateForm) {
        return studentService.updateStudent(id, customerUpdateForm);
    }
}
