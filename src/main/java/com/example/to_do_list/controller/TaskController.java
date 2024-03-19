package com.example.to_do_list.controller;

import com.example.to_do_list.dto.Detail;
import com.example.to_do_list.dto.GetTask;
import com.example.to_do_list.dto.ListTask;
import com.example.to_do_list.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListTask> getAll() {
        return taskService.getAllTasksInfo();
    }

    @PostMapping
    public ResponseEntity<GetTask> save( @Valid @RequestBody Detail detail ) throws URISyntaxException {
        GetTask newTask = taskService.save(detail);
        return ResponseEntity.created(new URI("/tasks/" + newTask.id()))
                .body(newTask);
    }

    @PatchMapping(value = "/{id}/status")
    public ResponseEntity<Void> markTaskAsCompleted(@PathVariable int id) {
        taskService.markTaskAsCompleted(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
