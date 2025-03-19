package com.rocketseat.service.tasks.Services;

import com.rocketseat.service.tasks.Enums.NotifiedEnum;
import com.rocketseat.service.tasks.NotificationDTO;
import com.rocketseat.service.tasks.Repositories.TaskRepository;
import com.rocketseat.service.tasks.communication.NotificationClient;
import com.rocketseat.service.tasks.entities.TasksEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TasksServices {
    private final TaskRepository taskRepository;
    private final NotificationClient notificationClient;

    public TasksServices(TaskRepository taskRepository, NotificationClient notificationClient) {
        this.taskRepository = taskRepository;
        this.notificationClient = notificationClient;
    }

    public TasksEntity save(TasksEntity tasksEntity) {
        return this.taskRepository.save(tasksEntity);
    }

    public void sendTasksDueDate(){
        LocalDateTime tomorrow = LocalDateTime.now().plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        List<TasksEntity> tasks = taskRepository.findDueDate(tomorrow, NotifiedEnum.NOT_NOTIFIED);
        for(TasksEntity task : tasks) {
            NotificationDTO notificationDTO = new NotificationDTO("Sua task, está: " + task.getTitle(), task.getEmail());
            notificationClient.sendNotification(notificationDTO);
            task.setNotifiedEnum(NotifiedEnum.NOTIFIED);
            taskRepository.save(task);
        }
    }
}
