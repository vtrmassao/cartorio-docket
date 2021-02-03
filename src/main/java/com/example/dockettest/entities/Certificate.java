package com.example.dockettest.entities;

import javax.persistence.*;

@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private Registry registry;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
