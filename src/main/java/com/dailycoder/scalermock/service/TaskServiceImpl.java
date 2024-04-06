package com.dailycoder.scalermock.service;

import com.dailycoder.scalermock.exception.DataNotFoundException;
import com.dailycoder.scalermock.vo.Task;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    private List<Task> tasks = new ArrayList<>();

    @Override
    @SneakyThrows
    public List<Task> getAllTask() {
        if(tasks==null || tasks.size()==0){
            throw  new DataNotFoundException("There are no tasks");
        }
        return tasks;
    }

    @Override
    @SneakyThrows
    public Task getTaskById(int id) {
        if(tasks==null || tasks.size()==0){
            throw  new DataNotFoundException("There are no tasks");
        }
        for(Task task:tasks){
            if(task.getId()==id)
                return task;
        }
        throw  new DataNotFoundException("There are no task with the provided id");
    }

    @Override
    public void createTask(Task task) {
        this.tasks.add(task);
    }

    @Override
    @SneakyThrows
    public void deleteTaskById(int id) {
        if(tasks==null || tasks.size()==0){
            throw  new DataNotFoundException("There are no tasks");
        }
        for(Task task:tasks){
            if(task.getId()==id)
                this.tasks.remove(task);
        }
    }
}
