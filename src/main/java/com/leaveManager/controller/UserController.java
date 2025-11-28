package com.leaveManager.controller;

import com.leaveManager.ApiResponse;
import com.leaveManager.dto.UserReqDto;
import com.leaveManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class UserController {

    private final UserService userService;

    @PostMapping("/new-employee")
    public ResponseEntity<ApiResponse<Void>> addEmployee(@RequestBody UserReqDto userReqDto){
        userService.addEmployee(userReqDto);

        ApiResponse<Void> response = new ApiResponse("success","User created sucessfully!",null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    






}
