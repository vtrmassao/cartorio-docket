package com.example.dockettest.dtos;

import javax.validation.constraints.NotNull;

public class RegistryDTO {
    @NotNull
    private String name;

    @NotNull
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
