package com.rocketseat.service.tasks.Controllers;

import com.rocketseat.service.tasks.Repositories.TaskRepository;
import com.rocketseat.service.tasks.Services.TasksServices;
import com.rocketseat.service.tasks.entities.TasksEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksServices tasksServices;

    public TasksController(TasksServices tasksServices) {
        this.tasksServices = tasksServices;
    }
    @PostMapping
    public ResponseEntity<TasksEntity> tasks(@RequestBody TasksEntity tasksEntity) {
        return ResponseEntity.ok(this.tasksServices.save(tasksEntity));
    }

}
