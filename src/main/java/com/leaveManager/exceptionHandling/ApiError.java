package com.leaveManager.exceptionHandling;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private int status;
}
