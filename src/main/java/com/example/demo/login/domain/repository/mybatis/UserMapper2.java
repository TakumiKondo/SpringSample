package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.User;

@Mapper
public interface UserMapper2 {

    /**
     * one user Register Method
     */
    public void insert(User user);

    /**
     * Select of one user Method
     */
    public User select(String userId);

    /**
     * Select of all user Method
     */
    public List<User> selectMany();

    /**
     * one user Update Method
     */
    public void update(User user);

    /**
     * one user Delete Method
     */
    public void delete(String userId);
}
