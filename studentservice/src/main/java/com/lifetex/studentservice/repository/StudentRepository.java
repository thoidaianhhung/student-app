package com.lifetex.studentservice.repository;

import com.lifetex.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student WHERE email = :email", nativeQuery = true)
    Optional<Student> findByEmail(String email);

    @Query(value = "CALL students_db.find_by_email_and_password(:in_email, :in_password)", nativeQuery = true)
    Optional<Student> findByEmailAndPassword(
            @Param("in_email") String email,
            @Param("in_password") String pwd);
}
