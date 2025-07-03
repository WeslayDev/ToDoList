package entities;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String email;
    private List<Task> tasks;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public List<Task> getTasks() {

        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public String toString() {
        return "User: " + username + " | Email: " + email + " | Total tasks: " + tasks.size();
    }
}