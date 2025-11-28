package com.leaveManager.dto;

import lombok.Data;

@Data
public class UserReqDto {
    private String name;
    private String password;
    private String email;
    private String designation;
    private double salary;
}
