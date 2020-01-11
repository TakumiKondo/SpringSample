package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.User;

public interface UserDao {
    public int count() throws DataAccessException;
    public void register(User user) throws DataAccessException;
    public User selectOne(String userId) throws DataAccessException;
//    public UserList selectMany() throws DataAccessException;
    public List<User> selectMany() throws DataAccessException;
    public void update(User user) throws DataAccessException;
    public void delete(String userId) throws DataAccessException;
    public void createCsv() throws DataAccessException;
}
