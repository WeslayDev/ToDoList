package utils;

import entities.User;

import java.io.*;
import java.util.List;

public class FileManager {

    public static void saveUsersToFile(List<User> users, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(users);
            System.out.println("Users saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static List<User> loadUsersFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved users found. Starting with empty list.");
            return new java.util.ArrayList<>();
        }
    }

}
