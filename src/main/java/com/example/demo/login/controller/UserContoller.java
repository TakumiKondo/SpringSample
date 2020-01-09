package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.model.UserList;
import com.example.demo.login.domain.service.UserService;

@Controller
public class UserContoller {
	@Autowired
	UserService userService;

	@GetMapping("/userList")
	public String getUserList(Model model) {
		model.addAttribute("contents", "login/userList::userList_contents");

		UserList userList = userService.selectMany();
		model.addAttribute("userList", userList);

		int count = userService.count();
		model.addAttribute("count", count);

		return "login/homeLayout";
	}

	@GetMapping("/userDetail/{id:.+}")
	public String getUserDetail(
			@ModelAttribute SignupForm signupForm
			,Model model
			,@PathVariable("id") String id) {

		System.out.println("id = " + id);

		model.addAttribute("contents", "login/userDetail::userDetail_contents");

		User user = userService.selectOne(id);
		signupForm.setUserId(user.id());
		signupForm.setUserName(user.name());
		signupForm.setBirthday(user.birthday());
		signupForm.setAge(user.age());
		signupForm.setMarrige(user.marrige());
		model.addAttribute("signupForm", signupForm);

		return "login/homeLayout";
	}

	@PostMapping(value="/userDetail", params="update")
	public String postUserDetailUpdate(@ModelAttribute SignupForm signupForm, Model model) {
		System.out.println("update called.");

		User user = new User(
				signupForm.getUserId()
				,signupForm.getPassword()
				,signupForm.getUserName()
				,signupForm.getBirthday()
				,signupForm.getAge()
				,signupForm.isMarrige()
				,""
		);
		userService.update(user);

		return getUserList(model);
	}
}
