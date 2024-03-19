package com.example.to_do_list.service;

import com.example.to_do_list.dto.Detail;
import com.example.to_do_list.dto.GetTask;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskServiceTest {
    private final TaskService taskService;

    @Autowired
    public TaskServiceTest(TaskService taskService) {
        this.taskService = taskService;
    }


    @Test
    void getTasks() {
        taskService.getAllTasksInfo().forEach(System.out::println);
    }


    @Test
    void save() {
        Detail detail = new Detail("Java", "Hello World!");
        GetTask task = taskService.save(detail);
        assertEquals(1, task.id());
    }

    @Test
    void delete() {
        taskService.deleteById(15);
    }



}
