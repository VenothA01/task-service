package com.dailycoder.scalermock.service;

import com.dailycoder.scalermock.vo.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    public List<Task> getAllTask();
    public Task getTaskById(int id);
    public void createTask(Task task);
    public void deleteTaskById(int id);

}
