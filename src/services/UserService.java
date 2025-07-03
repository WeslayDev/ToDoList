package services;

import entities.User;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private List<User> users = new ArrayList<>();
    private Scanner sc;

    public UserService(Scanner sc, List<User> users) {
        this.sc = sc;
        this.users = users;
    }

    public void showUserMenu() {
        int option = -1;

        while (option != 3) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1 - Register new User");
            System.out.println("2 - List users");
            System.out.println("3 - Exit user menu");
            System.out.print("Choose an option: ");

            option = InputUtils.readInt(sc, "Choose an option: ");

            switch (option) {
                case 1 -> registerUser();
                case 2 -> listUsers();
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void registerUser() {

        String username = InputUtils.readString(sc, "Enter username: ");
        String email = InputUtils.readString(sc, "Enter email: ");

        User newUser = new User(username, email);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    private void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        System.out.println("--- Registered Users ---");
        for (User user : users) {
            System.out.println(user);
        }
    }

        public User selectUser () {
            if (users.isEmpty()) {
                System.out.println("No Users registered.");
                return null;
            }

            System.out.println("--- Select a User ---");
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + " - " + users.get(i).getUsername());
            }

            int choice  = InputUtils.readInt(sc, "Choose user number: ");

            if (choice < 1 || choice > users.size()) {
                System.out.println("Invalid user selected.");
                return null;
            }
            return users.get(choice - 1);
        }
    }