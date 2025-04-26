package com.example.assignment.service;

import com.example.assignment.common.SuccessResponse;
import org.springframework.stereotype.Service;
import com.example.assignment.dto.HelloRequest;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {

    public String getHelloMessage() {
        return "Hello, TossPayments!";
    }

    public String getPersonalizedMessage(String name) {
        return "Hello, " + name + "!";
    }

//    public String generateMessage(HelloRequest request) {
//        return "Hello, " + request.getName() + "! You are " + request.getAge() + " years old.";
//    }
//
    public SuccessResponse<Map<String, String>> generateMessage(HelloRequest request) {
        Map<String, String> greeting = new HashMap<>();
        greeting.put("greeting", "Hello, " + request.getName() + "! You are " + request.getAge() + " years old.");

        return new SuccessResponse<>("200", "Success", greeting);
    }

}
