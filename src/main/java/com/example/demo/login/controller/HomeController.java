package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	final private String routing = "/home";

	@GetMapping(routing)
	public String getHome(Model model) {
		model.addAttribute("contents", "login/home::home_contents");
		return "login/homeLayout";
	}
}
