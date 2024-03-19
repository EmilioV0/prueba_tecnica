package com.example.to_do_list;

import com.example.to_do_list.entity.Task;
import com.example.to_do_list.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

	@Autowired
	private TaskRepository taskRepository;

	@Test
	void contextLoads() {
	}

}
