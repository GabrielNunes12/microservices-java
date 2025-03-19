package com.rocketseat.service.tasks.Schedule;

import com.rocketseat.service.tasks.Services.TasksServices;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksNotifySchedule {
    private final TasksServices tasksServices;

    public TasksNotifySchedule(TasksServices tasksServices) {
        this.tasksServices = tasksServices;
    }

    @Scheduled(fixedRate = 90)
    private void checkAndNotifyTasks() {
        System.out.println("Job checkAndNotifyTasks sendo executado");
        this.tasksServices.sendTasksDueDate();
        System.out.println("Job checkAndNotifyTasks foi executado com sucesso!");
    }
}
