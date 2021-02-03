package com.example.dockettest.controllers;

import com.example.dockettest.dtos.RegistryDTO;
import com.example.dockettest.entities.Registry;
import com.example.dockettest.services.RegistryService;
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
@RequestMapping("registries/")
public class RegistryController {
    @Autowired
    private RegistryService registryService;

    @GetMapping("create-form")
    public String showCreateForm(Registry registry) {
        return "registry-form";
    }

    @GetMapping("edit-form/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Registry registry = registryService.findById(id);

        model.addAttribute("registry", registry);
        return "edit-form";
    }

    @GetMapping("index")
    public String showIndex(Model model) {
        model.addAttribute("registries", registryService.findAll());

        return "index";
    }

    @PostMapping("create")
    public String createRegistry(@Valid RegistryDTO registry, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registry-form";
        }
        registryService.save(registry);

        return "redirect:index";
    }

    @GetMapping("delete/{id}")
    public String deleteRegistry(@PathVariable("id") Long id, Model model) {
        registryService.delete(id);
        model.addAttribute("registries", registryService.findAll());

        return "index";
    }

    @PostMapping("update/{id}")
    public String updateRegistry(@PathVariable("id") long id,@Valid Registry registry, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            registry.setId(id);
            return "edit-form";
        }
        registryService.update(registry);
        model.addAttribute("registries", registryService.findAll());

        return "index";
    }
}
