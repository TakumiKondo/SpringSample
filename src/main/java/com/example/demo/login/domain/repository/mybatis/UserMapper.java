package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.login.domain.model.User;

@Mapper
public interface UserMapper {
    final static String insertQuery = ""
        + "INSERT INTO users("
            + "id, password, name, birthday, age, marrige, role) VALUES ("
            + "#{id}, #{password}, #{name}, #{birthday}, #{age}, #{marrige}, #{role})";

    final static String selectQuery = ""
        + "SELECT * FROM users WHERE id = #{id}";

    final static String selectManyQuery = ""
        + "SELECT * FROM users";

    final static String updateQuery = ""
        + "UPDATE users SET "
            + "password = #{password}, name = #{name}, birthday = #{birthday}"
            + ", age = #{age}, marrige = #{marrige}, role = #{role} "
        + "WHERE id = #{id}";

    final static String deleteQuery = ""
        + "DELETE FROM users WHERE id = #{id}";


    /**
     * one user Register Method
     */
    @Insert(insertQuery)
    public void insert(User user);

    /**
     * Select of one user Method
     */
    @Select(selectQuery)
    public User select(String userId);

    /**
     * Select of all user Method
     */
    @Select(selectManyQuery)
    public List<User> selectMany();

    /**
     * one user Update Method
     */
    @Update(updateQuery)
    public void update(User user);

    /**
     * one user Delete Method
     */
    @Delete(deleteQuery)
    public void delete(String userId);
}
