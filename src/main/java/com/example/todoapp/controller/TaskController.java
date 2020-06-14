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
    public String addTask(Task task, Model model) {

        if (ifOnlyNumbers(task.getDescription())) {
            List<Task> taskList = taskService.findAllTasks();
            model.addAttribute("msg", "Description contains numbers only!");
            model.addAttribute("taskList", taskList);
            model.addAttribute("createTask", new Task());
            return "home";
        }

        if(DescriptionIsLessThanThreeFiveLetters(task.getDescription()) ){
            List<Task> taskList = taskService.findAllTasks();
            model.addAttribute("msg","Description is less than 5 letters!");
            model.addAttribute("taskList", taskList);
            model.addAttribute("createTask",new Task());
            return "home";
        }


        taskService.addTask(task);
        return "redirect:/todo/home";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/todo/home";
    }

    @GetMapping("/home")
    public String findAllTasks(Model model) {
        List<Task> taskList = taskService.findAllTasks();
        model.addAttribute("msg","");
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
    public String saveUpdate (Task task,Model model){

        if (ifOnlyNumbers(task.getDescription())) {
            model.addAttribute("msg", "Description contains numbers only! Please, Try again!");
            model.addAttribute("updateTask",task);
            return "updateForm";
        }

        if(DescriptionIsLessThanThreeFiveLetters(task.getDescription()) ){
            model.addAttribute("msg","Description is less than 5 letters! Please, Try again!");
            model.addAttribute("updateTask",task);
            return "updateForm";
        }

        taskService.updateTask(task.getId(),task.getDescription(),task.getDate());
        return "redirect:/todo/home";
    }

    @GetMapping("/backHome")
    public String backHome (){
        return "redirect:/todo/home";
    }

    public boolean DescriptionIsLessThanThreeFiveLetters(String Description){
        String str = Description.trim();
        System.out.println(str.length());
        if (str.length() < 5)
            return true;

        return false;
    }

    public boolean ifOnlyNumbers(String Description){
                boolean numeric = true;
                try {
                    Double num = Double.parseDouble(Description);
                } catch (NumberFormatException e) {
                    numeric = false;
                }

                if(numeric)
                    return true;
                else
                    return false;
    }

}
