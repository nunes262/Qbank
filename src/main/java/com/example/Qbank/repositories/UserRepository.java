package com.example.Qbank.repositories;

import java.util.HashMap;
import java.util.Map;

import com.example.Qbank.model.User;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();
    private Long idCounter = 1L;

    public void save(User user) {
        user = new User(idCounter++, user.getName(), user.getCpf(), user.getEmail(), user.getPassword());
        users.put(user.getEmail(), user);
    }

    public User findByEmail(String email) {
        return users.get(email);
    }

    public boolean existsByEmail(String email) {
        return users.containsKey(email);
    }
}