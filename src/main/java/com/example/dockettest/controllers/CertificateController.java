package com.example.dockettest.controllers;

import com.example.dockettest.dtos.CertificateDTO;
import com.example.dockettest.entities.Certificate;
import com.example.dockettest.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("certificates/")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping("create-form/{id}")
    public String showCreateForm(@PathVariable("id") Long id, Model model) {
        CertificateDTO certificate = new CertificateDTO();
        certificate.setRegistryId(id);

        model.addAttribute("certificate", certificate);
        return "certificate-form";
    }

    @GetMapping("certificate-list/{id}")
    public String showCertificateList(@PathVariable("id") Long id, Model model) {
        model.addAttribute("certificates", certificateService.findByRegistry(id));

        return "certificate-list";
    }

    @GetMapping("edit-form/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("certificate", certificateService.findById(id));

        return "certificate-edit-form";
    }

    @PostMapping("create")
    public String createCertificate(@Valid CertificateDTO certificate, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registry-form";
        }
        certificateService.save(certificate);

        model.addAttribute("certificates", certificateService.findByRegistry(certificate.getRegistryId()));
        return "certificate-list";
    }

    @GetMapping("delete/{id}")
    public String deleteCertificate(@PathVariable("id") Long id, Model model) {
        Certificate certificate = certificateService.delete(id);

        model.addAttribute("certificates", certificateService.findByRegistry(certificate.getRegistry().getId()));
        return "certificate-list";
    }

    @PostMapping("update")
    public String updateCertificate(@Valid CertificateDTO certificate, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            return "certificate-edit-form";
        }
        Certificate cer = certificateService.update(certificate);
        model.addAttribute("certificates", certificateService.findByRegistry(cer.getRegistry().getId()));
        return "certificate-list";
    }
}
