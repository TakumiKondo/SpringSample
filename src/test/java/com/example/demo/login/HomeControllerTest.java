package com.example.demo.login;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.login.domain.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    @WithMockUser
    public void ユーザリスト画面のユーザ件数テスト() throws Exception {

        when(service.count()).thenReturn(10);

        mockMvc.perform(get("/userList"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("合計：10件")));

    }
}
