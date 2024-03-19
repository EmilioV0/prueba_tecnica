package com.example.to_do_list.repository;

import com.example.to_do_list.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImp implements TaskRepository{
    private static final List<Task> tasks = new ArrayList<>();

    private TaskRepositoryImp() {}

    @Override
    public List<Task> getAllTasksInfo() {
        return tasks;
    }

    @Override
    public boolean save(Task task) {
        return tasks.add( task );
    }

    @Override
    public void markTaskAsCompleted(int id) {
        Task task = getById(id);
        task.markTaskAsCompleted();
    }

    @Override
    public void deleteById(int id) {
        tasks.remove(id - 1);
    }

    @Override
    public boolean existsById(int id) {
        return tasks.stream().anyMatch(task -> task.getId() == id);
    }

    @Override
    public Task getById(int id) {
        return tasks.get(id - 1);
    }
}

/*
* static {
        tasks = new ArrayList<Task>();
        tasks.add( new Task("Learn Java", "Read a book") );
    }
* */