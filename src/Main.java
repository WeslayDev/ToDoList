import services.UserService;
import services.TaskService;
import utils.FileManager;
import entities.User;
import utils.InputUtils;

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<User> users = FileManager.loadUsersFromFile("Users.dat");

        UserService userService = new UserService(sc, users);

        int option = -1;

        while (option != 3) {
            System.out.println("\n--- ToDoList Main Menu ---");
            System.out.println("1 - Manage Users");
            System.out.println("2 - Manage Tasks");
            System.out.println("3 - Exit");
            System.out.print("Choose an option: ");

            option = InputUtils.readInt(sc, "Choose an option: ");

            switch (option) {
                case 1 -> userService.showUserMenu();
                case 2 -> {
                    User selectedUser = userService.selectUser();
                    if (selectedUser != null) {
                        TaskService taskService = new TaskService(sc, selectedUser);
                        taskService.showMenu();
                    }
                }
                case 3 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid option. Try again");
            }
        }

        FileManager.saveUsersToFile(users, "users.dat");

        sc.close();
    }
}