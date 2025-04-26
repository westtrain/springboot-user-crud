package com.example.assignment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public class HelloRequest {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Min(value = 0, message = "Age must be 0 or greater")
    private Integer age;

    public HelloRequest() {
    }

    public HelloRequest(String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() { return age; }

    public void setAge(Integer age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
}
