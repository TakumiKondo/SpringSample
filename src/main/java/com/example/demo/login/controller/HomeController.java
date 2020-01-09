package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//	@Autowired
//	UserService userService;

	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents", "login/home::home_contents");
		return "login/homeLayout";
	}

//	@GetMapping("/userList")
//	public String getUserList(Model model) {
//		model.addAttribute("contents", "login/userList::userList_contents");
//
//		UserList userList = userService.selectMany();
//		model.addAttribute("userList", userList);
//
//		int count = userService.count();
//		model.addAttribute("count", count);
//
//		return "login/homeLayout";
//	}

}
