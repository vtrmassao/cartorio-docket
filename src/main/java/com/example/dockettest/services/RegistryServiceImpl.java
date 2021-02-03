package com.example.dockettest.services;

import com.example.dockettest.dtos.RegistryDTO;
import com.example.dockettest.entities.Registry;
import com.example.dockettest.repositories.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RegistryServiceImpl implements RegistryService {

    @Autowired
    private RegistryRepository registryRepository;

    @Override
    public List<Registry> findAll() {
        return registryRepository.findAll();
    }

    @Override
    public Registry findById(Long id) {
        return registryRepository.findById(id).get();
    }

    @Override
    public Boolean save(RegistryDTO registry) {
        try {
            Registry newRegistry = new Registry();
            newRegistry.setName(registry.getName());
            newRegistry.setAddress(registry.getAddress());
            registryRepository.save(newRegistry);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Registry registry) {
        return registryRepository.findById(registry.getId()).map(reg -> {
            reg.setAddress(registry.getAddress());
            reg.setName(registry.getName());
            registryRepository.save(reg);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Long id) {
        return registryRepository.findById(id).map(reg -> {
            registryRepository.delete(reg);
            return true;
        }).orElse(false);
    }
}
