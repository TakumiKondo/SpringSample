package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    final private String routing = "/login";

    @GetMapping("/login")
    public String getLogin() {
        return "login/login";
    }

    @PostMapping(routing)
    public String postLogin(Model model) {
        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String postLogout(Model model) {
        return "redirect:/login";
    }
}
