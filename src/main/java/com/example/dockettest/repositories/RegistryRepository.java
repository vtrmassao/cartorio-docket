package com.example.dockettest.repositories;

import com.example.dockettest.entities.Registry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryRepository extends JpaRepository<Registry, Long> {
}
