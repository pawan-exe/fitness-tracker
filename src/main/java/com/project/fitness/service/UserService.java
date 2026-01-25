package com.project.fitness.service;

import com.project.fitness.dto.RegisterUser;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserResponse register(RegisterUser registerUser) {
        User user = new User(null, registerUser.getEmail(), registerUser.getPassword(), registerUser.getFirstName(), registerUser.getLastName(), Instant.parse("2007-12-03T10:15:30.208Z").atZone(ZoneOffset.UTC).toLocalDateTime(), Instant.parse("2007-12-03T10:15:30.208Z").atZone(ZoneOffset.UTC).toLocalDateTime(), List.of(), List.of());
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
