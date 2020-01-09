package com.example.demo.login.domain.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.login.domain.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(
				rs.getString("id")
				,rs.getString("password")
				,rs.getString("name")
				,rs.getDate("birthday")
				,rs.getInt("age")
				,rs.getBoolean("marrige")
				,rs.getString("role")
		);

		return user;
	}

}
