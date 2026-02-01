package com.project.fitness.service;

import com.project.fitness.dto.RegisterUser;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterUser registerUser) {
        User user = User.builder()
                .email(registerUser.getEmail())
                .password(registerUser.getPassword())
                .firstName(registerUser.getFirstName())
                .lastName(registerUser.getLastName())
                .build();

        User savedUser = userRepository.save(user);
        return mappedToResponse(savedUser);
    }

    public UserResponse mappedToResponse(User savedUser){
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }
}
