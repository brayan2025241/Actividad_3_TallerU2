package com.brayancoronado.store.controller;

import com.brayancoronado.store.entity.Users;
import com.brayancoronado.store.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("editMode", false);
        return "user-form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Users user = usersService.findById(id);

        model.addAttribute("user", user);
        model.addAttribute("editMode", true);

        return "user-form";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("editMode", false);
            return "user-form";
        }

        usersService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("editMode", true);
            return "user-form";
        }

        usersService.update(user.getUserId(), user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        usersService.deleteById(id);
        return "redirect:/users";
    }
}