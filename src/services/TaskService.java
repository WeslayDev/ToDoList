package services;

import entities.Task;
import entities.User;
import utils.InputUtils;

import java.util.List;
import java.util.Scanner;

public class TaskService {

    private Scanner sc;
    private User currentUser;


    public TaskService(Scanner sc, User user) {
        this.sc = sc;
        this.currentUser = user;
    }

    public void showMenu() {
        int option = -1;

        while (option != 4) {
            System.out.println("\n--- Task Menu for " + currentUser.getUsername() + " ---");
            System.out.println("1 - Add Task");
            System.out.println("2 - View Tasks");
            System.out.println("3 - Mark Task as completed");
            System.out.println("4 - Back");

            option = InputUtils.readInt(sc, "Choose an option: ");

            switch (option) {
                case 32 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskAsCompleted();
                case 4 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addTask() {
        String title = InputUtils.readString(sc, "Enter task title: ");
        String description = InputUtils.readString(sc, "Enter task description: ");

        Task newTask = new Task(title, description);
        currentUser.addTask(newTask);

        System.out.println("Task added successfully!");
    }

    private void viewTasks() {
        List<Task> tasks = currentUser.getTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found for this user.");
            return;
        }

        System.out.println("--- Tasks for " + currentUser.getUsername() + " ---");
        for (Task task : tasks) {
            task.showTask();
        }
    }

    private void markTaskAsCompleted() {
        List<Task> tasks = currentUser.getTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark as completed.");
            return;
        }

        System.out.println("--- Select a task to mark as completed ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + " - " + tasks.get(i).getTitle() + (tasks.get(i).isCompleted() ? "[Completed]" : ""));
        }

        int choice = InputUtils.readInt(sc, "Choice task number: ");

        if (choice < 1 || choice > tasks.size()) {
            System.out.println("Invalid task selected.");
            return;
        }

        tasks.get(choice - 1).markAsCompleted();
        System.out.println("Task marked as completed!");

    }
}
