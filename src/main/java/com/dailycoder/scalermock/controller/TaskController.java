package com.dailycoder.scalermock.controller;

import com.dailycoder.scalermock.service.TaskService;
import com.dailycoder.scalermock.vo.Task;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@RestController
    @RequestMapping("/api/v1/tasks")
public class TaskController {


    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    @SneakyThrows
    public ResponseEntity<String> createTasK(@RequestBody Task task){
        if(task.getDescription()==null || task.getDescription().length()==0){
            return ResponseEntity.status(403).body("Description is mandatory");
        }
        if(task.getTitle()==null || task.getTitle().length()==0){
            return ResponseEntity.status(403).body("Title is mandatory");
        }
        taskService.createTask(task);
        return ResponseEntity.status(201).body("Task is created");
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        var response = taskService.getAllTask();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        var response = taskService.getTaskById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable int id){
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Task has been deleted");
    }
}
