package com.andres.app.apirest.Controller;

import com.andres.app.apirest.Model.Task;
import com.andres.app.apirest.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping(value = "/tasks")
    public List <Task> getTask(){
        return toDoRepository.findAll();
    }

    @PostMapping(value = "/saveTask")
    public String saveTask(@RequestBody Task task){
        toDoRepository.save(task);
        return "SavedTask";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updateTask = toDoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setState(task.getState());
        toDoRepository.save(updateTask);
        return "UpdatedTask";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask = toDoRepository.findById(id).get();
        toDoRepository.delete(deleteTask);
        return "DeletedTask";
    }
}
