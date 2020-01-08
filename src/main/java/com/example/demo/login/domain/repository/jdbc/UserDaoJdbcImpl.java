package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int count() throws DataAccessException {
		return 0;
	}

	@Override
	public void register(User user) throws DataAccessException {
	}

	@Override
	public User selectOne(String userId) throws DataAccessException {
		return new User();
	}

	@Override
	public List<User> selectMany() throws DataAccessException {
		return new ArrayList<User>();
	}

	@Override
	public void update(User user) throws DataAccessException {
	}

	@Override
	public void delete(User user) throws DataAccessException {
	}

	@Override
	public void createCsv() throws DataAccessException {
	}

}
