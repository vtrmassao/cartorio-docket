package com.example.dockettest.dtos;

import javax.validation.constraints.NotNull;

public class CertificateDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long registryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegistryId() {
        return registryId;
    }

    public void setRegistryId(Long registryId) {
        this.registryId = registryId;
    }
}
