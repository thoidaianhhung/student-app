package com.lifetex.studentservice.config;

import com.lifetex.studentservice.entity.Student;
import com.lifetex.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VTIBankUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(username).orElseThrow(() -> new
                UsernameNotFoundException("Student details not found for the student: " + username));
        List<GrantedAuthority> authorities = student.getAuthorities().stream().map(authority -> new
                SimpleGrantedAuthority(authority.getAuthorityName())).collect(Collectors.toList());
        return new User(student.getEmail(), student.getPwd(), authorities);
    }
}

