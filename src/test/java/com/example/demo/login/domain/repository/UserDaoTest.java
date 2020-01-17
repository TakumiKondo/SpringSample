package com.example.demo.login.domain.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class UserDaoTest {

    @Autowired
    @Qualifier("UserDaoJdbcImpl")
    UserDao dao;

    @Test
    public void countTest() {
        assertThat(dao.count(), is(4));
    }

    @Test
    @Sql("/testData.sql")
    public void addedCountTest() {
        assertThat(dao.count(), is(5));
    }
}
