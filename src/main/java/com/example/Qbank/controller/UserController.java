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
            scanner.close();
        }

    }
}