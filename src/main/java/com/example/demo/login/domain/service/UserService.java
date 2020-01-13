package com.example.demo.login.domain.service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Transactional
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

    public List<User> selectMany() {
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

    public void createCsv() throws DataAccessException {
        userDao.createCsv();
    }

    public byte[] getFile(String fileName) throws IOException {

        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath(fileName);
        byte[] bytes = Files.readAllBytes(path);

        return bytes;
    }
}
