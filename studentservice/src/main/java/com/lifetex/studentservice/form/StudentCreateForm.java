package com.lifetex.studentservice.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreateForm {
    @NotEmpty(message = "Full name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the student full name should be between 5 and 30")
    private String fullName;

    @NotEmpty(message = "Birth date can not be a null or empty")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Ngày sinh phải theo định dạng dd/MM/yyyy")
    private String birthDate;

    @NotEmpty(message = "Gender can not be a null or empty")
    @Pattern(regexp = "NAM|NU", message = "Gender must be NAM or NU")
    private String gender;

    @NotEmpty(message = "Password can not be a null or empty")
    private String pwd;

    @NotEmpty(message = "Email can not be a null or empty")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "Email phải theo định dạng")
    private String email;
}