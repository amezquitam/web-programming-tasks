package com.uraraka.socialz.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uraraka.socialz.dto.user.UserDTO;
import com.uraraka.socialz.entities.User;
import com.uraraka.socialz.services.UserService;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.Collections;
import java.util.List;


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
    void whenGetAllUsers_thenReturnListUsers() throws Exception {
        List<UserDTO> users = List.of(new UserDTO(1L, "test1", "aTest1", "uTest1",
                        "test1@gmail.com", Collections.emptyList(), Collections.emptyList()),
                new UserDTO(2L, "test2", "aTest2", "uTest2",
                        "test2@gmail.com", Collections.emptyList(), Collections.emptyList()));
        when(userService.getAllUsers()).thenReturn(users);
        ResultActions response = mockMvc.perform(get("/api/v1/users").contentType(APPLICATION_JSON));
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andExpect(jsonPath("$[0].id",Is.is(1)));
    }
}