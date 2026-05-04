package com.brayancoronado.store.controller;

import com.brayancoronado.store.entity.Sales;
import com.brayancoronado.store.service.SalesService;
import com.brayancoronado.store.service.CustomersService;
import com.brayancoronado.store.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;
    private final CustomersService customersService;
    private final UsersService usersService;

    public SalesController(SalesService salesService,CustomersService customersService, UsersService usersService) {

        this.salesService = salesService;
        this.customersService = customersService;
        this.usersService = usersService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("sales", salesService.findAll());
        return "sales";
    }

    @GetMapping("/new")
    public String showForm(Model model) {

        model.addAttribute("sale", new Sales());
        model.addAttribute("customersList", customersService.findAll());
        model.addAttribute("usersList", usersService.findAll());
        model.addAttribute("editMode", false);
        return "sale-form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {

        Sales sale = salesService.findById(id);
        model.addAttribute("sale", sale);
        model.addAttribute("customersList", customersService.findAll());
        model.addAttribute("usersList", usersService.findAll());
        model.addAttribute("editMode", true);
        return "sale-form";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute("sale") Sales sale, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("customersList", customersService.findAll());
            model.addAttribute("usersList", usersService.findAll());
            model.addAttribute("editMode", false);
            return "sale-form";
        }

        salesService.save(sale);
        return "redirect:/sales";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("sale") Sales sale, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("customersList", customersService.findAll());
            model.addAttribute("usersList", usersService.findAll());
            model.addAttribute("editMode", true);
            return "sale-form";
        }

        salesService.update(sale.getSaleId(), sale);
        return "redirect:/sales";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        salesService.deleteById(id);
        return "redirect:/sales";
    }
}