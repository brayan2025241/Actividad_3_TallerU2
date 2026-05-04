package com.brayancoronado.store.controller;

import com.brayancoronado.store.entity.SaleDetails;
import com.brayancoronado.store.service.SaleDetailsService;
import com.brayancoronado.store.service.ProductsService;
import com.brayancoronado.store.service.SalesService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sale-details")
public class SaleDetailsController {

    private final SaleDetailsService saleDetailsService;
    private final ProductsService productsService;
    private final SalesService salesService;

    public SaleDetailsController(SaleDetailsService saleDetailsService,ProductsService productsService,SalesService salesService) {
        this.saleDetailsService = saleDetailsService;
        this.productsService = productsService;
        this.salesService = salesService;
    }

    // LISTAR
    @GetMapping
    public String list(Model model) {
        model.addAttribute("details", saleDetailsService.findAll());
        return "sale-details";
    }

    // FORM NUEVO
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("saleDetail", new SaleDetails());
        model.addAttribute("productsList", productsService.findAll());
        model.addAttribute("salesList", salesService.findAll());
        model.addAttribute("editMode", false);

        return "sale-details-form";
    }

    // FORM EDITAR
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("saleDetail", saleDetailsService.findById(id));
        model.addAttribute("productsList", productsService.findAll());
        model.addAttribute("salesList", salesService.findAll());
        model.addAttribute("editMode", true);

        return "sale-details-form";
    }

    // GUARDAR
    @PostMapping("/save")
    public String create(@Valid @ModelAttribute("saleDetail") SaleDetails saleDetail,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("productsList", productsService.findAll());
            model.addAttribute("salesList", salesService.findAll());
            model.addAttribute("editMode", false);

            return "sale-details-form";
        }

        saleDetailsService.save(saleDetail);
        return "redirect:/sale-details";
    }

    // ACTUALIZAR
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("saleDetail") SaleDetails saleDetail,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("productsList", productsService.findAll());
            model.addAttribute("salesList", salesService.findAll());
            model.addAttribute("editMode", true);

            return "sale-details-form";
        }

        saleDetailsService.update(saleDetail.getSaleDetailId(), saleDetail);
        return "redirect:/sale-details";
    }

    // ELIMINAR
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        saleDetailsService.deleteById(id);
        return "redirect:/sale-details";
    }
}