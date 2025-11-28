package com.leaveManager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private String sucess;
    private T data;
}
