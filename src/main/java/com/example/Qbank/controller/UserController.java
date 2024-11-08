package com.example.Qbank.controller;

import com.example.Qbank.services.UserService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.Optional;

@Controller("/users")
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post("/login")
    public String login(@Body LoginRequest loginRequest) {
        if (userService.login(loginRequest.getEmail(), loginRequest.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid email or password.";
        }
    }

    @Post("/register")
    public String register(@Body RegisterRequest registerRequest) {
        if (userService.register(registerRequest.getName(), registerRequest.getCpf(), registerRequest.getEmail(), registerRequest.getPassword())) {
            return "Registration successful!";
        } else {
            return "Registration failed.";
        }
    }

    @Put("/update-profile")
    public String updateProfile(@Body UpdateProfileRequest updateProfileRequest) {
        if (userService.updateProfile(updateProfileRequest.getEmail(), updateProfileRequest.getNewName(), updateProfileRequest.getNewEmail(), updateProfileRequest.getNewPassword())) {
            return "Profile updated successfully!";
        } else {
            return "Profile update failed.";
        }
    }
}
