package com.example.demo.Service.Implements;

import com.example.demo.Entity.School;
import com.example.demo.Repository.SchoolRepository;
import com.example.demo.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SchoolServiceImplements implements SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() { return schoolRepository.findAll(); }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id: " + id + " does not exist."));
    }

    @Override
    public School updateSchool(School school, Long id) {
        School existingUser = getSchoolById(id);
        existingUser.setName(school.getName());
        existingUser.setName(school.getName());
        existingUser.setCp(school.getCp());
        return schoolRepository.save(existingUser);
    }

}
