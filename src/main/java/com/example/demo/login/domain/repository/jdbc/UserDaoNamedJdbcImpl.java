package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository("UserDaoNamedJdbcImpl")
public class UserDaoNamedJdbcImpl implements UserDao {

    @Autowired
    NamedParameterJdbcTemplate paramJdbcTemplate;

    @Override
    public int count() throws DataAccessException {
        String sql = "SELECT COUNT(*) FROM users";
        SqlParameterSource pramSource = new MapSqlParameterSource();
        int count = paramJdbcTemplate.queryForObject(sql, pramSource, Integer.class);

        return count;
    }

    @Override
    public void register(User user) throws DataAccessException {
        String sql = ""
            + "INSERT INTO users("
                + "id"
                + ",password"
                + ",name"
                + ",birthday"
                + ",age"
                + ",marrige"
                + ",role)"
            + " VALUES("
                + ":id"
                + ",:password"
                + ",:name"
                + ",:birthday"
                + ",:age"
                + ",:marrige"
                + ",:role)";

        SqlParameterSource paramMap = new MapSqlParameterSource()
            .addValue("id", user.id())
            .addValue("password", user.password())
            .addValue("name", user.name())
            .addValue("birthday", user.birthday())
            .addValue("age", user.age())
            .addValue("marrige", user.marrige())
            .addValue("role", user.role());

        paramJdbcTemplate.update(sql, paramMap);
    }

    @Override
    public User selectOne(String userId) throws DataAccessException {
        String sql = "SELECT * FROM users WHERE id = :id";
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("id", userId);
        Map<String, Object> userMap = paramJdbcTemplate.queryForMap(sql, paramMap);
        User user = new User(
                (String) userMap.get("id")
                ,(String) userMap.get("password")
                ,(String) userMap.get("name")
                ,(Date) userMap.get("birthday")
                ,((Integer) userMap.get("age")).intValue()
                ,(Boolean) userMap.get("marrige")
                ,(String) userMap.get("role")
         );

        return user;
    }

    @Override
    public List<User> selectMany() throws DataAccessException {
        String sql = "SELECT * FROM users";
        SqlParameterSource paramMap = new MapSqlParameterSource();
        List<Map<String, Object>> userMaps = paramJdbcTemplate.queryForList(sql, paramMap);

        List<User> userList = new ArrayList<>();
        for (Map<String, Object> userMap : userMaps) {
            User user = new User(
                    (String) userMap.get("id")
                    ,(String) userMap.get("password")
                    ,(String) userMap.get("name")
                    ,(Date) userMap.get("birthday")
                    ,((Integer) userMap.get("age")).intValue()
                    ,(Boolean) userMap.get("marrige")
                    ,(String) userMap.get("role")
             );
            userList.add(user);
        }

        return userList;
    }

    @Override
    public void update(User user) throws DataAccessException {
        String sql = ""
            + "UPDATE"
                + " users"
            + " SET"
                + " password = :password"
                + ",name = :name"
                + ",birthday = :birthday"
                + ",age = :age"
                + ",marrige = :marrige"
            + " WHERE"
                + " id = :id;";

        SqlParameterSource paramMap = new MapSqlParameterSource()
              .addValue("password", user.password())
              .addValue("name", user.name())
              .addValue("birthday", user.birthday())
              .addValue("age", user.age())
              .addValue("marrige", user.marrige())
              .addValue("id", user.id());

        paramJdbcTemplate.update(sql, paramMap);
    }

    @Override
    public void delete(String userId) throws DataAccessException {
        String sql = ""
            + "DELETE"
            + " FROM"
                + " users"
            + " WHERE"
                + " id = :id;";

        SqlParameterSource paramMap = new MapSqlParameterSource()
            .addValue("id", userId);

        paramJdbcTemplate.update(sql, paramMap);
    }

    @Override
    public void createCsv() throws DataAccessException {
        // TODO 自動生成されたメソッド・スタブ
        String sql = ""
            + "SELECT"
                + " *"
            + " FROM"
                + " users";

        UserRowCallbackHandler userRowCallbackHandler = new UserRowCallbackHandler();

        paramJdbcTemplate.query(sql, userRowCallbackHandler);
    }


//
//    @Override
//    public void update(User user) throws DataAccessException {
//        String sql = "UPDATE" + " users" + " SET" + " password = ?" + ",name = ?" + ",birthday = ?" + ",age = ?"
//                + ",marrige = ?" + " WHERE" + " id = ?;";
//
//        jdbcTemplate.update(sql, user.password(), user.name(), user.birthday(), user.age(), user.marrige(), user.id());
//    }
//
//    @Override
//    public void delete(String userId) throws DataAccessException {
//        String sql = "DELETE " + " FROM users" + " WHERE id = ?";
//        jdbcTemplate.update(sql, userId);
//    }
//
//    @Override
//    public void createCsv() throws DataAccessException {
//        String sql = "SELECT * FROM users";
//        UserRowCallbackHandler userRowCallbackHandler = new UserRowCallbackHandler();
//        jdbcTemplate.query(sql, userRowCallbackHandler);
//    }

}
