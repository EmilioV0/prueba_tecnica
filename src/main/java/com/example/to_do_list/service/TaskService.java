package com.example.to_do_list.service;

import com.example.to_do_list.dto.Detail;
import com.example.to_do_list.dto.GetTask;
import com.example.to_do_list.dto.ListTask;

import java.util.List;


public interface TaskService {
    List<ListTask> getAllTasksInfo();
    GetTask save(Detail task);
    void markTaskAsCompleted(int id);
    void deleteById(int id);
}
