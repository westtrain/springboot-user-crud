package com.example.assignment.controller;

import com.example.assignment.common.SuccessResponse;
import com.example.assignment.dto.HelloRequest;
import com.example.assignment.service.HelloService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import  java.util.Map;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return helloService.getHelloMessage();
    }

//    @PostMapping("/hello")
//    public String postHello(@RequestBody @Valid HelloRequest request) {
//        return helloService.getPersonalizedMessage(request.getName());
//    }

    @PostMapping("/hello")
    public SuccessResponse<Map<String, String>> sayHello(@RequestBody @Valid HelloRequest request) {
        return helloService.generateMessage(request);
    }


}
