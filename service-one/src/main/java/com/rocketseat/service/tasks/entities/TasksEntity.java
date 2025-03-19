package com.rocketseat.service.tasks.entities;

import com.rocketseat.service.tasks.Enums.NotifiedEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity(name = "Task")
@Table(name = "task")
public class TasksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private NotifiedEnum notifiedEnum;
    private LocalDateTime dueDate;
    private String title;
    private String email;

    public TasksEntity() {
    }

    public TasksEntity(Long id, NotifiedEnum notifiedEnum, LocalDateTime dueDate, String title, String email) {
        this.id = id;
        this.notifiedEnum = notifiedEnum;
        this.dueDate = dueDate;
        this.title = title;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotifiedEnum getNotifiedEnum() {
        return notifiedEnum;
    }

    public void setNotifiedEnum(NotifiedEnum notifiedEnum) {
        this.notifiedEnum = notifiedEnum;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
