package com.example.demo.Service;


import com.example.demo.Entity.School;

import java.util.List;


public interface SchoolService {

    School createSchool(School school);

    List<School> getAllSchools();

    School getSchoolById(Long id);

    School updateSchool(School school, Long id);
}
