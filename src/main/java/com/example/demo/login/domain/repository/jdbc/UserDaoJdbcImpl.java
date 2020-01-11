package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int count() throws DataAccessException {
        String sql = "SELECT COUNT(*) FROM users";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);

        return count;
    }

    @Override
    public void register(User user) throws DataAccessException {
        String sql = "INSERT INTO users(" + "id" + ",password" + ",name" + ",birthday" + ",age" + ",marrige" + ",role)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, user.id(), user.password(), user.name(), user.birthday(), user.age(), user.marrige(),
                user.role());

        System.out.println("登録成功");
    }

    @Override
    public User selectOne(String id) throws DataAccessException {
        String sql = "SELECT *" + " FROM" + " users" + " WHERE" + " id = ?";
        Map<String, Object> oneUser = jdbcTemplate.queryForMap(sql, id);

        User user = new User((String) oneUser.get("id"), (String) oneUser.get("password"), (String) oneUser.get("name"),
                (Date) oneUser.get("birthday"), ((Integer) oneUser.get("age")).intValue(),
                (Boolean) oneUser.get("marrige"), (String) oneUser.get("role"));

        return user;
    }

    @Override
    public List<User> selectMany() throws DataAccessException {
        String sql = "SELECT " + "id" + ",name" + ",birthday" + ",age" + ",marrige" + ",role" + " FROM users";

        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);
        List<User> userList = new ArrayList<User>();
        for(Map<String, Object> eachUser: users) {
            User user = new User(
                    (String) eachUser.get("id")
                    ,(String) eachUser.get("password")
                    ,(String) eachUser.get("name")
                    ,(Date) eachUser.get("birthday")
                    ,((Integer) eachUser.get("age")).intValue()
                    ,(Boolean) eachUser.get("marrige")
                    ,(String) eachUser.get("role")
             );
            userList.add(user);
        }

        return userList;
    }

    @Override
    public void update(User user) throws DataAccessException {
        String sql = "UPDATE" + " users" + " SET" + " password = ?" + ",name = ?" + ",birthday = ?" + ",age = ?"
                + ",marrige = ?" + " WHERE" + " id = ?;";

        jdbcTemplate.update(sql, user.password(), user.name(), user.birthday(), user.age(), user.marrige(), user.id());
    }

    @Override
    public void delete(String userId) throws DataAccessException {
        String sql = "DELETE " + " FROM users" + " WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void createCsv() throws DataAccessException {
    }

}
