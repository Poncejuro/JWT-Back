package com.example.demo.Repository;

import com.example.demo.Entity.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certifications,Long> {
}
