package com.example.Qbank.controller;

import java.util.Scanner;

import com.example.Qbank.services.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void viewBalance(String email) {
        double balance = userService.checkBalance(email);
        System.out.println("Your current balance is: " + balance);
    }

    public void transfer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String senderEmail = scanner.nextLine();

        System.out.print("Enter recipient email: ");
        String recipientEmail = scanner.nextLine();

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        userService.transfer(senderEmail, recipientEmail, amount);
    }

    public void viewTransactionHistory(String email) {
        userService.printTransactionHistory(email);
    }

    public void login() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public void register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }
}




// package com.example.Qbank.controller;

// import com.example.Qbank.services.UserService;
// import io.micronaut.http.annotation.*;
// import jakarta.inject.Inject;
// import java.util.Optional;

// @Controller("/users")
// public class UserController {

//     private final UserService userService;

//     @Inject
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @Post("/login")
//     public String login(@Body LoginRequest loginRequest) {
//         if (userService.login(loginRequest.getEmail(), loginRequest.getPassword())) {
//             return "Login successful!";
//         } else {
//             return "Invalid email or password.";
//         }
//     }

//     @Post("/register")
//     public String register(@Body RegisterRequest registerRequest) {
//         if (userService.register(registerRequest.getName(), registerRequest.getCpf(), registerRequest.getEmail(), registerRequest.getPassword())) {
//             return "Registration successful!";
//         } else {
//             return "Registration failed.";
//         }
//     }

//     @Put("/update-profile")
//     public String updateProfile(@Body UpdateProfileRequest updateProfileRequest) {
//         if (userService.updateProfile(updateProfileRequest.getEmail(), updateProfileRequest.getNewName(), updateProfileRequest.getNewEmail(), updateProfileRequest.getNewPassword())) {
//             return "Profile updated successfully!";
//         } else {
//             return "Profile update failed.";
//         }
//     }
// }
