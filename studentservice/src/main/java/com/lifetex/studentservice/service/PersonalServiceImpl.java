package com.lifetex.studentservice.service;

import com.lifetex.studentservice.dto.PersonalDto;
import com.lifetex.studentservice.form.PersonalCreateForm;
import com.lifetex.studentservice.form.PersonalUpdateForm;
import com.lifetex.studentservice.mapper.PersonalMapper;
import com.lifetex.studentservice.repository.PersonalRepository;
import com.lifetex.studentservice.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonalServiceImpl implements PersonalService {
    private final PersonalRepository personalRepository;
    private final StudentRepository studentRepository;

    @Override
    public Page<PersonalDto> findAll(Pageable pageable) {
        return personalRepository.findAll(pageable).map(PersonalMapper::map);
    }

    @Override
    public Page<PersonalDto> findByStudentId(Long studentId, Pageable pageable) {
        return personalRepository.findByStudentId(studentId, pageable).map(PersonalMapper::map);
    }

    @Override
    public PersonalDto findById(Long id) {
        return personalRepository.findById(id).map(PersonalMapper::map).orElse(null);
    }

    @Override
    public PersonalDto create(Long studentId, PersonalCreateForm form) {
        var optional = studentRepository.findById(studentId);
        if (optional.isEmpty()) {
            return null;
        }
        var student = optional.get();
        var personal = PersonalMapper.map(form);
        personal.setStudent(student);
        var savedPersonal = personalRepository.save(personal);
        return PersonalMapper.map(savedPersonal);
    }

    @Override
    public PersonalDto update(Long id, PersonalUpdateForm form) {
        var optional = personalRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var personal = optional.get();
        PersonalMapper.map(form, personal);
        var savedPersonal = personalRepository.save(personal);
        return PersonalMapper.map(savedPersonal);
    }

    @Override
    public void deleteById(Long id) {
        personalRepository.deleteById(id);
    }
}
