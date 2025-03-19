package com.rocketseat.service.notification.Controllers;

import com.rocketseat.service.notification.DTOs.NotificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/notification")
@RestController
public class NotificationController {

    @PostMapping
    public ResponseEntity<Void> getNotification(@RequestBody NotificationDTO notificationDTO) {
        return ResponseEntity.ok().build();
    }
}
