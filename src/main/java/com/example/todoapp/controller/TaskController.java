package com.example.todoapp.controller;

import com.example.todoapp.domain.Task;
import com.example.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public String addTask(Task task) {
        taskService.addTask(task);
        return "redirect:/todo/allTasksList";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/todo/allTasksList";
    }

    @GetMapping("/allTasksList")
    public String findAllTasks(Model model) {
        List<Task> taskList = taskService.findAllTasks();
        model.addAttribute("taskList", taskList);
        model.addAttribute("createTask",new Task());
        return "home";
    }


    @GetMapping("/updateTask/{id}")
    public String updateTask (@PathVariable int id, Model model){
        Task task = taskService.findTaskById(id);
        model.addAttribute("updateTask",task);
        return "updateForm";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate (Task task){
        taskService.updateTask(task.getId(),task.getDescription(),task.getDate());
        return "redirect:/todo/allTasksList";
    }

    @GetMapping("/backHome")
    public String backHome (){
        return "redirect:/todo/allTasksList";
    }

}
