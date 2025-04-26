package com.example.assignment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Min(value = 0, message = "Age must not be 0 or greater")
    private Integer age;

    public UserRequest() {}

    public UserRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
