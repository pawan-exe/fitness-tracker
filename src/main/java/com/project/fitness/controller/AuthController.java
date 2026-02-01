package com.project.fitness.controller;

import com.project.fitness.dto.RegisterUser;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterUser registerUser){
        UserResponse userResponse =  userService.register(registerUser);
        return ResponseEntity.ok(userResponse);
    }
}
