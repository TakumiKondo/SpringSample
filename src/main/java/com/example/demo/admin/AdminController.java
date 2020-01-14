package com.example.demo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
//	@Autowired
//	UserService userService;

    @GetMapping("/admin")
    public String getHome(Model model) {
        model.addAttribute("contents", "admin/admin::admin_contents");
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
