package com.example.Qbank.repositories;

import java.util.HashMap;
import java.util.Map;

import com.example.Qbank.model.Account;
import com.example.Qbank.model.User;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();
    private Map<Long, Account> accounts = new HashMap<>();
    private Long idCounter = 1L;

    public void save(User user) {
        user = new User(idCounter++, user.getName(), user.getCpf(), user.getEmail(), user.getPassword());
        users.put(user.getEmail(), user);
        accounts.put(user.getId(), new Account(user.getId())); // Cria uma conta para o usuário
    }

    public User findByEmail(String email) {
        return users.get(email);
    }

    public Account findAccountByUserId(Long userId) {
        return accounts.get(userId);
    }

    public boolean existsByEmail(String email) {
        return users.containsKey(email);
    }
}



// package com.example.Qbank.repositories;

// import com.example.Qbank.model.User;
// import io.micronaut.data.annotation.Repository;
// import io.micronaut.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {
    
//     Optional<User> findByEmail(String email);
    
//     boolean existsByEmail(String email);
// }
