package com.Ecommerce.Ecommerce_Management_System.shared;

import lombok.Getter;

import java.util.List;

@Getter
public class GlobalResponse<T> {
    private final static String success = "Success";
    private final static String failed = "Error";
    private final String status;
    private final T data;
    private final List<ErrorItems> error;

    public record ErrorItems(String message) {
    }

    public GlobalResponse(List<ErrorItems> errors) {
        this.status = failed;
        this.data = null;
        this.error = errors;
    }

    public GlobalResponse(T data) {
        this.status = success;
        this.data = data;
        this.error = null;

    }
}
