package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.model.valid.GroupOrder;
import com.example.demo.login.domain.service.UserService;

@Controller
public class SignupController {
	final private String routing = "/signup";

	@Autowired
	private UserService userService;

	@GetMapping(routing)
	public String getSignup(@ModelAttribute SignupForm form, Model model) {
//		Marrige marrige = new Marrige();
//		model.addAttribute("marrige", marrige);

		return "login/signup";
	}

	@PostMapping(routing)
	public String postSignup(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return getSignup(form, model);
		}
		System.out.println(form);	// debug

		User user = new User(
				form.getUserId()
				,form.getPassword()
				,form.getUserName()
				,form.getBirthday()
				,form.getAge()
				,form.isMarrige()
				,"STAFF");
		userService.register(user);

		return "redirect:/login";
	}
}



