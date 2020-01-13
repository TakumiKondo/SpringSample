package com.example.demo.login.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;

@Repository("UserDaoJdbcImpl2")
public class UserDaoJdbcImpl2 extends UserDaoJdbcImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User selectOne(String id) throws DataAccessException {
        // SQL文を作成
        String sql = ""
            + "SELECT"
                + " *"
            + " FROM"
               + " users"
            + " WHERE"
                + " id = ?";

        // queryForObjectメソッドでSQLを実行し、
        // UserRowMapperのマッピング結果である、Userオブジェクトを受け取る。
        UserRowMapper rowMapper = new UserRowMapper();
        User user = jdbcTemplate.queryForObject(sql, rowMapper, id);

        return user;
    }

    @Override
    public List<User> selectMany() throws DataAccessException {
        // SQL文を作成
        String sql = ""
            + "SELECT"
                + " *"
            + " FROM"
                + " users";

        // queryメソッドでSQLを実行
        // UserRowMapperのマッピング結果である、UserオブジェクトのListを受け取る。
        UserRowMapper rowMapper = new UserRowMapper();
        List<User> userList = jdbcTemplate.query(sql, rowMapper);

        return userList;
    }

}
