package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.domain.model.User;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    @Qualifier("RestServiceMybatisImpl")
    RestService service;

    @GetMapping("/user/{id:.+}")
    public User user(@PathVariable("id") String userId) {
        return service.select(userId);
    }

    @GetMapping("/users")
    public List<User> users() {
        return service.selectMany();
    }

    @PostMapping("/user/add")
    public String add(@RequestBody User user) {
        service.insert(user);

        return "{result:ok}";
    }

    @PutMapping("/user/update")
    public String update(@RequestBody User user) {
        service.update(user);

        return "{result:ok}";
    }

    @DeleteMapping("/user/delete/{id:.+}")
    public String delete(@PathVariable("id") String userId) {
        service.delete(userId);

        return "{result:ok}";
    }
}
