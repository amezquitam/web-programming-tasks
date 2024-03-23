package com.uraraka.socialz.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uraraka.socialz.dto.user.UserDTO;
import com.uraraka.socialz.entities.User;
import com.uraraka.socialz.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;
    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUsers() {

    }
}