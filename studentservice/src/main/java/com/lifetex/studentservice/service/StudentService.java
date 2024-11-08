package com.lifetex.studentservice.service;


import com.lifetex.studentservice.dto.LoginResponseDTO;
import com.lifetex.studentservice.dto.StudentDto;
import com.lifetex.studentservice.form.LoginRequestForm;
import com.lifetex.studentservice.form.StudentCreateForm;
import com.lifetex.studentservice.form.StudentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StudentService {


    /**
     * Retrieves a list of all users.
     *
     * @return a list of CustomerDto objects representing all users
     */
    Page<StudentDto> findAllStudents(Pageable pageable);

    /**
     * @param email - Input Mobile Number
     * @return User Details based on a given mobileNumber
     */
    StudentDto findByEmail(String email);

    ResponseEntity<String> registerUser(StudentCreateForm studentCreateForm);

    ResponseEntity<LoginResponseDTO> loginUser(LoginRequestForm loginRequestForm);


    /**
     * @param id, customerUpdateForm - CustomerDto Object
     * @return update of User details
     */
    StudentDto updateStudent(Long id, StudentUpdateForm customerUpdateForm);
}
