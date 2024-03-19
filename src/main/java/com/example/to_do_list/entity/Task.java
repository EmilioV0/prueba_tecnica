package com.example.to_do_list.entity;

import lombok.*;

@Getter
@Setter
@ToString
public class Task {
    private int id;
    private String title;
    private String description;
    private Boolean state;

    private static int numberOfTasks;

    public Task(String title, String description) {
        numberOfTasks++;
        this.id = numberOfTasks;
        this.title = title;
        this.description = description;
        this.state = false;
    }

    public void markTaskAsCompleted() {
        this.state = !this.state;
    }
}
