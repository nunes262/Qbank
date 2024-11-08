package com.example.Qbank.services;

import com.example.Qbank.model.User;
import com.example.Qbank.repositories.UserRepository;
import com.example.Qbank.validator.CPFValidator;
import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }

    public boolean register(String name, String cpf, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            System.out.println("Email already exists.");
            return false;
        }

        if (!CPFValidator.isValidCPF(cpf)) {
            System.out.println("Invalid CPF.");
            return false;
        }

        User newUser = new User(name, cpf, email, password);
        userRepository.save(newUser);
        return true;
    }

    public boolean updateProfile(String email, String newName, String newEmail, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            System.out.println("User not found.");
            return false;
        }

        User user = userOptional.get();
        user.setName(newName != null ? newName : user.getName());
        user.setEmail(newEmail != null ? newEmail : user.getEmail());
        user.setPassword(newPassword != null ? newPassword : user.getPassword());

        userRepository.update(user);
        return true;
    }
}
