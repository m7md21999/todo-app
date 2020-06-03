package com.example.todoapp.service;

import com.example.todoapp.dao.TaskDao;
import com.example.todoapp.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void addTask(Task task) {
        taskDao.addTask(task);
    }

    @Override
    public void deleteTask(int id) {
        taskDao.deleteTask(id);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskDao.findAllTasks();
    }

    @Override
    public Task findTaskById(int id) {
        return taskDao.findTaskById(id);
    }

    @Override
    public void updateTask(int id, String description, Date date) {
        taskDao.updateTask(id,description,date);
    }
}
