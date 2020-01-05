package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;

@Controller
public class SignupController {
	final private String routing = "/signup";

	@GetMapping(routing)
	public String getSignup(@ModelAttribute SignupForm form, Model model) {
//		Marrige marrige = new Marrige();
//		model.addAttribute("marrige", marrige);

		return "login/signup";
	}

	@PostMapping(routing)
	public String postSignup(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return getSignup(form, model);
		}

		System.out.println(form);	// debug
		return "redirect:/login";
	}
}



