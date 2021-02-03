package com.example.dockettest.repositories;

import com.example.dockettest.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByRegistryId(Long id);
}
