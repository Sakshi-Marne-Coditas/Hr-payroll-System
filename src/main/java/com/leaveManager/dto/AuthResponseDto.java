package com.leaveManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthResponseDto {
    private String message;
    private Long uid;
    private String username;
    private String email;
    private String token;

}

