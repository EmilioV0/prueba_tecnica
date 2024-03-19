package com.example.to_do_list.repository;

import com.example.to_do_list.entity.Task;
import java.util.List;

public interface TaskRepository {
    List<Task> getAllTasksInfo();
    boolean save(Task task);
    void markTaskAsCompleted(int id);
    void deleteById(int id);
    Task getById(int id);
    boolean existsById(int id);
}
