package entities;

import java.io.Serializable;

public class Task implements Serializable {

    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public void showTask() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Status: " + (completed ? "Completed" : "Pending"));
        System.out.println("----------------------");
    }
}
