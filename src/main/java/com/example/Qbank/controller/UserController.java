package com.example.Qbank.controller;

import java.util.Scanner;

import com.example.Qbank.services.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.login(email, password)) {
            System.out.println("Login successful!");
            updateProfile(email);
        } else {
            System.out.println("Invalid email or password.");
        }
        scanner.close();
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.register(name, cpf, email, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }
        scanner.close();
    }

    public void updateProfile(String email) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        newName = newName.isEmpty() ? null : newName;

        System.out.print("Enter new email (leave blank to keep current): ");
        String newEmail = scanner.nextLine();
        newEmail = newEmail.isEmpty() ? null : newEmail;

        System.out.print("Enter new password (leave blank to keep current): ");
        String newPassword = scanner.nextLine();
        newPassword = newPassword.isEmpty() ? null : newPassword;

        if (userService.updateProfile(email, newName, newEmail, newPassword)) {
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Profile update failed.");
        }
        scanner.close();
    }
}
