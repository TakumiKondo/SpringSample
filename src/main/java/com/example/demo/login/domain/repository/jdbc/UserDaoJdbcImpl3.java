package com.example.demo.login.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;

@Repository("UserDaoJdbcImpl3")
public class UserDaoJdbcImpl3 extends UserDaoJdbcImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User selectOne(String id) throws DataAccessException {
        String sql = "SELECT * FROM users WHERE id = ?";
        RowMapper<User> userRowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, userRowMapper, id);

        return user;
    }

    @Override
    public List<User> selectMany() throws DataAccessException {
        String sql = "SELECT"
                + " id"
                + ",name"
                + ",birthday"
                + ",age"
                + ",marrige"
                + ",role"
                + " FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> userList = jdbcTemplate.query(sql, rowMapper);

        return userList;
    }

}
