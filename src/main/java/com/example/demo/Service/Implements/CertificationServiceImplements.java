package com.example.demo.Service.Implements;

import com.example.demo.Entity.Certifications;
import com.example.demo.Repository.CertificationRepository;
import com.example.demo.Service.CertificactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CertificationServiceImplements implements CertificactionService {

    @Autowired
    CertificationRepository certificationRepository;

    @Override
    public Certifications createCertification(Certifications certifications) {
        return certificationRepository.save(certifications);
    }

    @Override
    public List<Certifications> getAllCertifications() { return certificationRepository.findAll(); }

    @Override
    public Certifications getCertificationById(Long id) {
        return certificationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Certification with id: " + id + " does not exist."));
    }

    @Override
    public Certifications updateCertification(Certifications certifications, Long id) {
        Certifications existingCertification = getCertificationById(id);
        existingCertification.setName(certifications.getName());
        existingCertification.setDescription(certifications.getDescription());
        existingCertification.setDate(certifications.getDate());
        return certificationRepository.save(existingCertification);
    }


}
