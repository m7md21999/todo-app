package com.example.todoapp.controller;

import com.example.todoapp.domain.Task;
import com.example.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class TaskControllerREST {

    @Autowired
    TaskService taskService;

    @GetMapping("/task/{id}")
    public Task findTaskById(@PathVariable int id) {
        Task task = taskService.findTaskById(id);
        return task;
    }

    @GetMapping("/tasksList")
    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public HashMap<String, Object> add(@RequestBody Task task) {
        HashMap<String, Object> response = new HashMap<>();
        taskService.addTask(task);
        response.put("task", task);
        response.put("msg", "Added Successfully!");
        return response;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String,Object> delete(@PathVariable int id) {
        HashMap<String,Object> response = new HashMap<>();
        taskService.deleteTask(id);
        response.put("id",id);
        response.put("msg","Deleted Successfully");
        return response;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String,Object> update(@PathVariable int id,@RequestBody Task task) {
        HashMap<String,Object> response = new HashMap<>();
        taskService.updateTask(id,task.getDescription(),task.getDate());
        response.put("task",task);
        response.put("msg","Updated Successfully");
        return response;
    }

}
