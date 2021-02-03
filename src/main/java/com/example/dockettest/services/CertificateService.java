package com.example.dockettest.services;

import com.example.dockettest.dtos.CertificateDTO;
import com.example.dockettest.entities.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> findAll();
    List<Certificate> findByRegistry(Long registryId);
    Certificate findById(Long id);
    Boolean save(CertificateDTO certificateDTO);
    Certificate update(CertificateDTO certificate);
    Certificate delete(Long id);
}
