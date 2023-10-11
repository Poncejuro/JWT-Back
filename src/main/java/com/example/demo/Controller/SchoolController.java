package com.example.demo.Controller;

import com.example.demo.Entity.School;
import com.example.demo.Service.SchoolService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/school")
@CrossOrigin(origins = "*")
@Log4j2 // to print in console
public class SchoolController {
    @Autowired
    SchoolService schoolService;


    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        School newSchool = schoolService.createSchool(school);
        log.info("Creating a new School.");
        return new ResponseEntity<>(newSchool, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> school = schoolService.getAllSchools();
        log.info("Getting all schools.");
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        School school = schoolService.getSchoolById(id);
        log.info("Getting a school by Id.");
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<School> updateSchool(@RequestBody School school, @PathVariable Long id) {
        School updateSchool= schoolService.updateSchool(school, id);
        log.info("Updating an existing school.");
        return new ResponseEntity<>(updateSchool, HttpStatus.OK);
    }
}
