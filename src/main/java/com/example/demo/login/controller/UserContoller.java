package com.example.demo.login.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class UserContoller {
    @Autowired
    UserService userService;

    @GetMapping("/userList")
    public String getUserList(Model model) {
        model.addAttribute("contents", "login/userList::userList_contents");

        List<User> userList = userService.selectMany();
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

        User user = new User(
                signupForm.getUserId()
                ,signupForm.getPassword()
                ,signupForm.getUserName()
                ,signupForm.getBirthday()
                ,signupForm.getAge()
                ,signupForm.isMarrige()
                ,""
        );
        try {
            userService.update(user);
        } catch(DataAccessException e) {
            model.addAttribute("exception", "更新処理失敗");
        };




        return getUserList(model);
    }

    @PostMapping(value="/userDetail", params="delete")
    public String postUserDetailDelete(@ModelAttribute SignupForm signupForm, Model model) {

        userService.delete(signupForm.getUserId());

        return getUserList(model);
    }

    @GetMapping("/userList/csv")
    public ResponseEntity<byte[]> getUserListCsv(){

        userService.createCsv();
        byte[] bytes = null;

        try {
            bytes = userService.getFile("file.csv");
        } catch(IOException e) {
            e.printStackTrace();
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "text/csv; charset=UTF-8");
        httpHeaders.setContentDispositionFormData("filename", "file.csv");

        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }

}
