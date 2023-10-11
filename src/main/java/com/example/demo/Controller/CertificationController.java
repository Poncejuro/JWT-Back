package com.example.demo.Controller;

import com.example.demo.Entity.Certifications;
import com.example.demo.Service.CertificactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/certification")
@CrossOrigin(origins = "*")
@Log4j2 // to print in console
public class CertificationController {
    @Autowired
    CertificactionService certificactionService;


    @PostMapping
    public ResponseEntity<Certifications> createCertification(@RequestBody Certifications certifications) {
        Certifications newCertification = certificactionService.createCertification(certifications);
        log.info("Creating a new Certification.");
        return new ResponseEntity<>(newCertification, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Certifications>> getAllCertifications() {
        List<Certifications> certifications = certificactionService.getAllCertifications();
        log.info("Getting all Certifications.");
        return new ResponseEntity<>(certifications, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Certifications> getCertificationById(@PathVariable Long id) {
        Certifications certifications = certificactionService.getCertificationById(id);
        log.info("Getting a Certification by Id.");
        return new ResponseEntity<>(certifications, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Certifications> updateCertification(@RequestBody Certifications certifications, @PathVariable Long id) {
        Certifications updateCertification= certificactionService.updateCertification(certifications, id);
        log.info("Updating an existing Certification.");
        return new ResponseEntity<>(updateCertification, HttpStatus.OK);
    }
}
