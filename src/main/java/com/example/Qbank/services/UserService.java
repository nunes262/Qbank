package com.example.Qbank.services;

import com.example.Qbank.model.Account;
import com.example.Qbank.model.User;
import com.example.Qbank.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public boolean register(String name, String cpf, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            System.out.println("Email already exists.");
            return false;
        }

        User newUser = new User(null, name, cpf, email, password);
        userRepository.save(newUser);
        return true;
    }

    public double checkBalance(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }

        Account account = userRepository.findAccountByUserId(user.getId());
        return account.getBalance();
    }

    public boolean transfer(String senderEmail, String recipientEmail, double amount) {
        User sender = userRepository.findByEmail(senderEmail);
        User recipient = userRepository.findByEmail(recipientEmail);

        if (sender == null || recipient == null) {
            System.out.println("Invalid sender or recipient.");
            return false;
        }

        Account senderAccount = userRepository.findAccountByUserId(sender.getId());
        Account recipientAccount = userRepository.findAccountByUserId(recipient.getId());

        if (senderAccount.transfer(amount, recipientAccount)) {
            System.out.println("Transfer successful!");
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }

    public void printTransactionHistory(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }

        Account account = userRepository.findAccountByUserId(user.getId());
        System.out.println("Transaction History:");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}



// package com.example.Qbank.services;

// import com.example.Qbank.model.User;
// import com.example.Qbank.repositories.UserRepository;
// import com.example.Qbank.validator.CPFValidator;
// import jakarta.inject.Singleton;
// import java.util.Optional;

// @Singleton
// public class UserService {
//     private final UserRepository userRepository;

//     public UserService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     public boolean login(String email, String password) {
//         Optional<User> userOptional = userRepository.findByEmail(email);
//         return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
//     }

//     public boolean register(String name, String cpf, String email, String password) {
//         if (userRepository.existsByEmail(email)) {
//             System.out.println("Email already exists.");
//             return false;
//         }

//         if (!CPFValidator.isValidCPF(cpf)) {
//             System.out.println("Invalid CPF.");
//             return false;
//         }

//         User newUser = new User(name, cpf, email, password);
//         userRepository.save(newUser);
//         return true;
//     }

//     public boolean updateProfile(String email, String newName, String newEmail, String newPassword) {
//         Optional<User> userOptional = userRepository.findByEmail(email);
//         if (userOptional.isEmpty()) {
//             System.out.println("User not found.");
//             return false;
//         }

//         User user = userOptional.get();
//         user.setName(newName != null ? newName : user.getName());
//         user.setEmail(newEmail != null ? newEmail : user.getEmail());
//         user.setPassword(newPassword != null ? newPassword : user.getPassword());

//         userRepository.update(user);
//         return true;
//     }
// }
