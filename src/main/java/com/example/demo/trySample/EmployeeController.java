package com.example.demo.trySample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public String postShowEmployee(@RequestParam("id") int id, Model model) {
        Employee emp = employeeService.findOne(id);
        model.addAttribute("id", emp.getId());
        model.addAttribute("name", emp.getName());
        model.addAttribute("age", emp.age());

        return "employee";
    }
}
