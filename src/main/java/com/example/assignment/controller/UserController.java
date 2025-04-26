package com.example.assignment.controller;

import com.example.assignment.common.SuccessResponse;
import com.example.assignment.dto.UserRequest;
import com.example.assignment.dto.UserResponse;
import com.example.assignment.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public SuccessResponse<String> createUser(@RequestBody @Valid UserRequest request) {
        return userService.addUser(request);
    }

    @GetMapping
    public SuccessResponse<List<UserResponse>> getUser() {
        return userService.getAllUsers();
    }

    @PutMapping("/{index}")
    public SuccessResponse<String> updateUser(@PathVariable int index, @RequestBody @Valid UserRequest request) {
        return userService.updateUser(index, request);
    }

    @DeleteMapping("/{index}")
    public SuccessResponse<String> deleteUser(@PathVariable int index) {
        return userService.deleteUser(index);
    }
}
