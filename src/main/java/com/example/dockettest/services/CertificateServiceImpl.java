package com.example.dockettest.services;

import com.example.dockettest.dtos.CertificateDTO;
import com.example.dockettest.entities.Certificate;
import com.example.dockettest.entities.Registry;
import com.example.dockettest.repositories.CertificateRepository;
import com.example.dockettest.repositories.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private RegistryRepository registryRepository;

    @Override
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    @Override
    public List<Certificate> findByRegistry(Long registryId) {
        return certificateRepository.findByRegistryId(registryId);
    }

    @Override
    public Certificate findById(Long id) {
        return certificateRepository.findById(id).get();
    }

    @Override
    public Boolean save(CertificateDTO certificateDTO) {
        try {
            Certificate newCertificate = new Certificate();
            Registry registry = registryRepository.findById(certificateDTO.getRegistryId()).get();
            if(registry == null) {
                return false;
            }
            newCertificate.setRegistry(registry);
            newCertificate.setName(certificateDTO.getName());
            certificateRepository.save(newCertificate);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Certificate update(CertificateDTO certificate) {
        return certificateRepository.findById(certificate.getId()).map(cer -> {
            cer.setName(certificate.getName());
            certificateRepository.save(cer);
            return cer;
        }).orElse(null);
    }

    @Override
    public Certificate delete(Long id) {
        return certificateRepository.findById(id).map(cer -> {
            certificateRepository.delete(cer);
            return cer;
        }).orElse(null);
    }
}
