package com.example.dockettest.services;

import com.example.dockettest.dtos.RegistryDTO;
import com.example.dockettest.entities.Registry;
import java.util.List;

public interface RegistryService {
    List<Registry> findAll();
    Registry findById(Long id);
    Boolean save(RegistryDTO registry);
    Boolean update(Registry registry);
    Boolean delete(Long id);
}
