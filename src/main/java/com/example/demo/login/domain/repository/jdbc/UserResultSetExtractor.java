package com.example.demo.login.domain.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.demo.login.domain.model.User;

public class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

    @Override
    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<User> userList = new ArrayList<User>();
        while(rs.next()) {
            User user = new User(
                    rs.getString("id")
//                    ,rs.getString("password")
                    ,""
                    ,rs.getString("name")
                    ,rs.getDate("birthday")
                    ,rs.getInt("age")
                    ,rs.getBoolean("marrige")
                    ,rs.getString("role")
             );
            userList.add(user);
        }

//        if(userList.size() == 0) {
//            throw new EmptyResultDataAccessException(1);
//        }

        return userList;
    }

}
