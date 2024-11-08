package com.lifetex.studentservice.repository;

import com.lifetex.studentservice.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
