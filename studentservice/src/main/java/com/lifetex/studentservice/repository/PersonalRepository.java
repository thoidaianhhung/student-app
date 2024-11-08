package com.lifetex.studentservice.repository;


import com.lifetex.studentservice.entity.Personal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    Page<Personal> findByStudentId(Long studentId, Pageable pageable);
}
