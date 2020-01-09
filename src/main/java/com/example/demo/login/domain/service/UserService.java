package com.example.demo.login.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.model.UserList;
import com.example.demo.login.domain.repository.UserDao;

@Service
public class UserService {

	@Autowired
	@Qualifier("UserDaoJdbcImpl2")
	UserDao userDao;

	public void register(User user) {
		userDao.register(user);
	}

	public int count() {
		return userDao.count();
	}

	public UserList selectMany() {
		return userDao.selectMany();
	}

	public User selectOne(String id) {
		return userDao.selectOne(id);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(String userId) {
		userDao.delete(userId);
	}
}
