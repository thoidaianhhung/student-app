package com.lifetex.studentservice.service;

import com.lifetex.studentservice.dto.PersonalDto;
import com.lifetex.studentservice.form.PersonalCreateForm;
import com.lifetex.studentservice.form.PersonalUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonalService {
    Page<PersonalDto> findAll(Pageable pageable);

    Page<PersonalDto> findByStudentId(Long studentId, Pageable pageable);

    PersonalDto findById(Long id);

    PersonalDto create(Long studentId, PersonalCreateForm form);

    PersonalDto update(Long studentId, PersonalUpdateForm form);

    void deleteById(Long id);
}
