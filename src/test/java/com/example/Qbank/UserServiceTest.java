package com.example.Qbank;

import com.example.Qbank.model.User;
import com.example.Qbank.repositories.UserRepository;
import com.example.Qbank.services.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testLoginSuccessful() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        User user = new User(1L, "Test User", "12345678900", email, password);

        when(userRepository.findByEmail(email)).thenReturn(user);

        // Act
        boolean result = userService.login(email, password);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        // Arrange
        String email = "test@example.com";
        String password = "wrongpassword";
        User user = new User(1L, "Test User", "12345678900", email, "password");

        when(userRepository.findByEmail(email)).thenReturn(user);

        // Act
        boolean result = userService.login(email, password);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testRegisterSuccess() {
        // Arrange
        String email = "newuser@example.com";
        String cpf = "12345678900";
        User newUser = new User(null, "New User", cpf, email, "password");

        when(userRepository.existsByEmail(email)).thenReturn(false);
        doNothing().when(userRepository).save(any(User.class));

        // Act
        boolean result = userService.register("New User", cpf, email, "password");

        // Assert
        assertTrue(result);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testRegisterFailsForDuplicateEmail() {
        // Arrange
        String email = "existing@example.com";

        when(userRepository.existsByEmail(email)).thenReturn(true);

        // Act
        boolean result = userService.register("Existing User", "12345678900", email, "password");

        // Assert
        assertFalse(result);
    }

    @Test
    public void testUpdateProfile() {
        // Arrange
        String email = "test@example.com";
        User user = new User(1L, "Test User", "12345678900", email, "password");

        when(userRepository.findByEmail(email)).thenReturn(user);

        // Act
        boolean result = userService.updateProfile(email, "Updated Name", "updated@example.com", "newpassword");

        // Assert
        assertTrue(result);
        verify(userRepository, times(1)).save(user); // Confirm save called with actual user instance
        assertEquals("Updated Name", user.getName());
        assertEquals("updated@example.com", user.getEmail());
        assertEquals("newpassword", user.getPassword());
    }
}
