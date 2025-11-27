package com.leaveManager.controller;

import com.leaveManager.dto.AuthRequestDto;
import com.leaveManager.dto.AuthResponseDto;
import com.leaveManager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public AuthResponseDto login(@Valid @RequestBody AuthRequestDto request){

        return userService.login(request);
    }

}
