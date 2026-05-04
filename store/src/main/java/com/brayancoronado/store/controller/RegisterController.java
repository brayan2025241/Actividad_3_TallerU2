package com.brayancoronado.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private InMemoryUserDetailsManager memoryUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String showForm() {
        return "register";
    }

    @PostMapping
    public String registrar(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        if (memoryUserDetailsManager.userExists(username)) {
            model.addAttribute("message", "The user already exists");
            return "register";
        }

        UserDetails nuevoUsuario = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();

        memoryUserDetailsManager.createUser(nuevoUsuario);

        model.addAttribute("message", "Successfully registered user");

        return "login";
    }
}