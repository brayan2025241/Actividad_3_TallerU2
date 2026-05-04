package com.brayancoronado.store.controller;

import com.brayancoronado.store.entity.Customers;
import com.brayancoronado.store.service.CustomersService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("customers", customersService.findAll());
        return "customers";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customers());
        model.addAttribute("editMode", false);
        return "customers-form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Customers customer = customersService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("editMode", true);
        return "customers-form";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute("customer") Customers customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("editMode", false);
            return "customers-form";
        }
        customersService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("customer") Customers customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("editMode", true);
            return "customers-form";
        }
        customersService.update(customer.getCustomerId(), customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        customersService.deleteById(id);
        return "redirect:/customers";
    }
}