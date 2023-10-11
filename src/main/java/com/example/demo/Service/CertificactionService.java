package com.example.demo.Service;


import com.example.demo.Entity.Certifications;

import java.util.List;

public interface CertificactionService {

    Certifications createCertification(Certifications certifications);

    List<Certifications> getAllCertifications();

    Certifications getCertificationById(Long id);

    Certifications updateCertification(Certifications certifications, Long id);
}
