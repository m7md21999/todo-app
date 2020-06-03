package com.example.todoapp.dao;

import com.example.todoapp.domain.Task;

import java.util.Date;
import java.util.List;

public interface TaskDao {
    void addTask(Task task);
    void deleteTask(int id);
    List<Task> findAllTasks();
    Task findTaskById(int id);
    void updateTask(int id, String description, Date date);
}
