package com.example.demo.rest;

import java.util.List;

import com.example.demo.login.domain.model.User;

public interface RestService {

    public void insert(User user);
    public User select(String userId);
    public List<User> selectMany();
    public void update(User user);
    public void delete(String userId);

}
