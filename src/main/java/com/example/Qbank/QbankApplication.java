package com.example.Qbank;

import com.example.Qbank.controller.UserController;
import com.example.Qbank.repositories.UserRepository;
import com.example.Qbank.services.UserService;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		UserRepository userRepository = new UserRepository();
		UserService userService = new UserService(userRepository);
		UserController userController = new UserController(userService);

		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("\n==== QBank Menu ====");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Check Balance");
			System.out.println("4. Transfer Money");
			System.out.println("5. View Transaction History");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consumes the newline

			switch (option) {
				case 1:
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
						System.out.println("Registration failed. Email already exists.");
					}
					break;

				case 2:
					System.out.print("Enter email: ");
					String loginEmail = scanner.nextLine();
					System.out.print("Enter password: ");
					String loginPassword = scanner.nextLine();

					if (userService.login(loginEmail, loginPassword)) {
						System.out.println("Login successful!");
					} else {
						System.out.println("Invalid email or password.");
					}
					break;

				case 3:
					System.out.print("Enter your email: ");
					String emailForBalance = scanner.nextLine();
					userController.viewBalance(emailForBalance);
					break;

				case 4:
					userController.transfer();
					break;

				case 5:
					System.out.print("Enter your email: ");
					String emailForHistory = scanner.nextLine();
					userController.viewTransactionHistory(emailForHistory);
					break;

				case 6:
					running = false;
					System.out.println("Exiting. Thank you for using QBank!");
					break;

				default:
					System.out.println("Invalid option. Please try again.");
			}
		}

		scanner.close();
	}
}



// package com.example.Qbank;

// import io.micronaut.runtime.Micronaut;

// public class QbankApplication {

//     public static void main(String[] args) {
//         Micronaut.run(QbankApplication.class);
//     }
// }
