package com.example.to_do_list.service;

import com.example.to_do_list.dto.Detail;
import com.example.to_do_list.dto.GetTask;
import com.example.to_do_list.dto.ListTask;
import com.example.to_do_list.entity.Task;
import com.example.to_do_list.exception.ResourceNotFoundException;
import com.example.to_do_list.exception.TaskAlreadyCompletedException;
import com.example.to_do_list.mapper.TaskMapper;
import com.example.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    private static final String entityName = "Task";

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository,
                          TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<ListTask> getAllTasksInfo() {
        List<Task> tasks = taskRepository.getAllTasksInfo();
        return taskMapper.toListTasks(tasks);
    }

    @Override
    public GetTask save(Detail detail) {
        Task task = taskMapper.toTask(detail);
        taskRepository.save(task);
        return taskMapper.toGetTask(task);
    }

    @Override
    public void markTaskAsCompleted(int id) {
        if ( !taskRepository.existsById(id) ) {
            throw new ResourceNotFoundException(entityName, id, HttpStatus.NOT_FOUND);
        }

        Task task = taskRepository.getById(id);

        if (task.getState()) {
            throw new TaskAlreadyCompletedException(entityName, id, HttpStatus.CONFLICT);
        }

        taskRepository.markTaskAsCompleted(id);
    }

    @Override
    public void deleteById(int id) {
        if ( !taskRepository.existsById(id) ) {
            throw new ResourceNotFoundException(entityName, id, HttpStatus.NOT_FOUND);
        }

        taskRepository.deleteById(id);
    }
}
