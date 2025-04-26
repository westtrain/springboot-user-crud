package com.example.assignment.common;

public class SuccessResponse<T> {

    private String code;
    private String message;
    private T data;

    public SuccessResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}