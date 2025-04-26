package com.example.assignment.controller;

import com.example.assignment.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void registerUser_shouldReturnOk() throws Exception {
        // given
        String userJson = "{ \"name\": \"John\", \"age\": 25 }";

        // when & then
        mockMvc.perform(
                        post("/users")
                                .contentType("application/json")
                                .content(userJson)
                )
                .andExpect(status().isOk());
    }

    @Test
    void getUsers_shouldReturnOk() throws Exception {
        mockMvc.perform(
                        get("/users")
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void updateUser_shouldReturnOk() throws Exception {
        // given
        int index = 0; // 예시로 0번 인덱스 유저 수정
        String updatedUserJson = "{ \"name\": \"josh\", \"age\": 30 }";

        // when & then
        mockMvc.perform(
                        put("/users/{index}", index)
                                .contentType("application/json")
                                .content(updatedUserJson)
                )
                .andExpect(status().isOk());
    }

    @Test
    void deleteUser_shouldReturnOk() throws Exception {
        // given
        int index = 0; // 예시로 0번 인덱스 유저 삭제

        // when & then
        mockMvc.perform(
                        delete("/users/{index}", index)
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

}
