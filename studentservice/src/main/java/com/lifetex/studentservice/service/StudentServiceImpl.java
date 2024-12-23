package com.lifetex.studentservice.service;

import com.lifetex.studentservice.constants.ApplicationConstants;
import com.lifetex.studentservice.dto.LoginResponseDTO;
import com.lifetex.studentservice.dto.StudentDto;
import com.lifetex.studentservice.entity.Authority;
import com.lifetex.studentservice.entity.Student;
import com.lifetex.studentservice.form.LoginRequestForm;
import com.lifetex.studentservice.form.StudentCreateForm;
import com.lifetex.studentservice.form.StudentUpdateForm;
import com.lifetex.studentservice.mapper.StudentMapper;
import com.lifetex.studentservice.repository.AuthorityRepository;
import com.lifetex.studentservice.repository.StudentRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final AuthenticationManager authenticationManager;
    private final Environment env;
    private final StudentRepository studentRepository;
    private final AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<LoginResponseDTO> loginUser(LoginRequestForm loginRequestForm) {
        String jwt = "";
        var student = studentRepository.findByEmailAndPassword(loginRequestForm.username(), loginRequestForm.password());
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginResponseDTO("Wrong username or password", null));
        }
        org.springframework.security.core.Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(loginRequestForm.username(),
                loginRequestForm.password());
        Authentication authenticationResponse = authenticationManager.authenticate(authentication);
        if (null != authenticationResponse && authenticationResponse.isAuthenticated() && null != env) {
            String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY,
                    ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
            SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            jwt = Jwts.builder().issuer("NGUYEN VAN HUNG").subject("JWT Token")
                    .claim("username", authenticationResponse.getName())
                    .claim("authorities", authenticationResponse.getAuthorities().stream().map(
                            GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                    .issuedAt(new java.util.Date())
                    .expiration(new java.util.Date((new java.util.Date()).getTime() + 120000))
                    .signWith(secretKey).compact();
        }
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstants.JWT_HEADER, jwt)
                .body(new LoginResponseDTO(HttpStatus.OK.getReasonPhrase(), jwt));
    }

    @Override
    public StudentDto updateStudent(Long id, StudentUpdateForm customerUpdateForm) {
        var optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var student = optional.get();
        StudentMapper.map(customerUpdateForm, student);
        var savedStudent = studentRepository.save(student);
        return StudentMapper.map(savedStudent);
    }

    @Override
    public Page<StudentDto> findAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable).map(StudentMapper::map);
    }

    @Override
    public StudentDto findByEmail(String email) {
        return studentRepository.findByEmail(email).map(StudentMapper::map).orElse(null);
    }

    @Override
    public ResponseEntity<String> registerUser(StudentCreateForm studentCreateForm) {
        var student = StudentMapper.map(studentCreateForm);
        student.setRole(Student.Role.ROLE_USER);
        var savedStudent = studentRepository.save(student);
        var authority = new Authority();
        authority.setAuthorityName(savedStudent.getRole().toString());
        authority.setStudent(savedStudent);
        authorityRepository.save(authority);
        if (savedStudent.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body("Given user details are successfully registered");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("Student registration failed");
        }
    }
}
