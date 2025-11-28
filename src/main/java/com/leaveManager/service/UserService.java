package com.leaveManager.service;

import com.leaveManager.Entity.Role;
import com.leaveManager.Entity.User;
import com.leaveManager.constants.RoleName;
import com.leaveManager.dto.AuthRequestDto;
import com.leaveManager.dto.AuthResponseDto;
import com.leaveManager.dto.UserReqDto;
import com.leaveManager.repository.RoleRepository;
import com.leaveManager.repository.UserRepository;
import com.leaveManager.security.CustomUserDetails;
import com.leaveManager.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private RoleRepository roleRepository;


    public AuthResponseDto login(@Valid AuthRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(request.getEmail());
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtUtil.generateToken(userDetails.getUsername(), userDetails.getAuthorities().iterator().next().getAuthority());

        return new AuthResponseDto("Login successful",
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                token);
    }

    public void addEmployee(UserReqDto userReqDto) {
        Role role = roleRepository.findByRoleName(RoleName.EMPLOYEE).orElseThrow(() -> new RuntimeException("Role not found"));

        if (userRepository.existsByEmail(userReqDto.getEmail())){
            throw new RuntimeException("User already exist");
        }
        User user = new User();
        user.setEmail(userReqDto.getEmail());
        user.setPassword(userReqDto.getPassword());
        user.setSalary(userReqDto.getSalary());
        user.setDesignation(userReqDto.getDesignation());
        user.setUsername(userReqDto.getName());
        user.setRole(role);

        userRepository.save(user);


    }
}
