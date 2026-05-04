package com.brayancoronado.store.controller;

import com.brayancoronado.store.entity.Products;
import com.brayancoronado.store.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // LISTAR
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products";
    }

    // MOSTRAR FORM
    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("product", new Products());
        return "product-form";
    }

    // GUARDAR
    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Products product,
                              BindingResult result) {

        if (result.hasErrors()) {
            return "product-form";
        }

        productsService.save(product);
        return "redirect:/products";
    }

    // EDITAR
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Products product = productsService.findById(id);
        model.addAttribute("product", product);
        return "product-form";
    }

    // ELIMINAR
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productsService.deleteById(id);
        return "redirect:/products";
    }
}