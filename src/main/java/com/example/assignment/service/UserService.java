package com.example.assignment.service;

import com.example.assignment.dto.UserRequest;
import com.example.assignment.dto.UserResponse;
import com.example.assignment.common.SuccessResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private  final List<UserResponse> users = new ArrayList<>();

    public SuccessResponse<String> addUser(UserRequest request) {
        UserResponse user = new UserResponse(request.getName(), request.getAge());
        users.add(user);
        return new SuccessResponse<>("200", "User created successfully", null);
    }

    public SuccessResponse<List<UserResponse>> getAllUsers() {
        return new SuccessResponse<>("200", "User list fetched successfully", users);
    }

    public SuccessResponse<String> updateUser(int index, UserRequest userRequest) {
        if (index >= users.size() || index < 0) {
            throw new IllegalArgumentException("Invalid user index");
        }
        UserResponse updateUser = new UserResponse(userRequest.getName(), userRequest.getAge());
        users.set(index, updateUser);
        return new SuccessResponse<>("200", "User updated successfully", null);
    }

    public SuccessResponse<String> deleteUser(int index) {
        if (index >= users.size() || index < 0) {
            throw new IllegalArgumentException("Invalid user index");
        }
        users.remove(index);
        return new SuccessResponse<>("200", "User deleted successfully", null);
    }
}
