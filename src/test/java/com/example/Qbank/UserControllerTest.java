package com.example.Qbank;

import com.example.Qbank.controller.UserController;
import com.example.Qbank.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class UserControllerTest {

    private UserService userService;
    private UserController userController;
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    public void testLoginSuccess() {
        // Arrange
        String input = "test@example.com\npassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(userService.login("test@example.com", "password")).thenReturn(true);

        // Act
        userController.login();

        // Assert
        verify(userService, times(1)).login("test@example.com", "password");

        // Restore System.in
        System.setIn(originalIn);
    }

    @Test
    public void testRegisterSuccess() {
        // Arrange
        String input = "New User\n12345678900\nnewuser@example.com\npassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(userService.register("New User", "12345678900", "newuser@example.com", "password")).thenReturn(true);

        // Act
        userController.register();

        // Assert
        verify(userService, times(1)).register("New User", "12345678900", "newuser@example.com", "password");

        // Restore System.in
        System.setIn(originalIn);
    }
}
